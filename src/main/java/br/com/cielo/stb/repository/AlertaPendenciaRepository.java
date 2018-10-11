package br.com.cielo.stb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.cielo.stb.entity.PendenciasBandeira;

@Repository
public class AlertaPendenciaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<PendenciasBandeira> consultaPendencias() {

		String consultaPendencias = "select ban.cd_bndr as codigoBandeira, ban.NM_BNDR nomeBandeira, IN_APRS_BNDR as indicadorApresentacaoBandeira,\r\n"
				+ "    (select count(*) from TBBINCR_PNDN_CNVR_VALR_CMPO p where ban.cd_bndr=p.cd_bndr and p.CD_STCO_PNDN = 'PE') as pendenciasBandeira,\r\n"
				+ "    (select count(*) from tbbincr_acrg ac where ban.cd_bndr=ac.cd_bndr and ac.IN_LBRD_UTLZ='N') as pendenciasAccount\r\n"
				+ "    from tbbincr_bndr ban";

		List<PendenciasBandeira> pendencias = this.jdbcTemplate.query(consultaPendencias,
				new BeanPropertyRowMapper<PendenciasBandeira>(PendenciasBandeira.class));

		if (pendencias.size() > 0) {
			PendenciasBandeira outrasBandeiras = new PendenciasBandeira();
			outrasBandeiras.setCodigoBandeira(0);
			outrasBandeiras.setNomeBandeira("Outras bandeiras");

			pendencias.add(outrasBandeiras);

			for (PendenciasBandeira pendencia : pendencias) {

				if (pendencia.isAgrupado()) {

					outrasBandeiras.setPendenciasAccount(outrasBandeiras.getPendenciasAccount() + pendencia.getPendenciasAccount());
					outrasBandeiras.setPendenciasBandeira(outrasBandeiras.getPendenciasBandeira() + pendencia.getPendenciasBandeira());
				}
			}

			pendencias.removeIf(PendenciasBandeira::isAgrupado);
			pendencias.removeIf(PendenciasBandeira::hasNoPendencia);
		}
		return pendencias;
	}

}
