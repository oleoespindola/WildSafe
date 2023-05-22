package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EspecieModel {
    
    @JsonProperty("faunaFlora")
    private String faunaFlora;
    
    @JsonProperty("grupo")
    private String grupo;

    @JsonProperty("familia")
    private String familia;

    @JsonProperty("especieSimplificado")
    private String especieSimplificado;

    @JsonProperty("nomeComum")
    private String nomeComum;

    @JsonProperty("categoriadeAmeaca")
    private String categoriadeAmeaca;

    @JsonProperty("siglaCategoriadeAmeaca")
    private String siglaCategoriadeAmeaca;

    @JsonProperty("bioma")
    private String bioma;
    
    @JsonProperty("principaisAmeacas")
    private String principaisAmeacas;

    @JsonProperty("presencaEmAreasProtegidas")
    private String presencaEmAreasProtegidas;
    
    @JsonProperty("planodeAcaoNacionalparaConservacaoPAN")
    private String planodeAcaoNacionalparaConservacaoPAN;
    
    @JsonProperty("ordenamentoPesqueiro")
    private String ordenamentoPesqueiro;
    
    @JsonProperty("niveldeProtecaoNaEstrategiaNacional")
    private String niveldeProtecaoNaEstrategiaNacional;
    
    @JsonProperty("especieExclusivaDoBrasil")
    private String especieExclusivaDoBrasil;
    
    @JsonProperty("estadosDeOcorrencia")
    private String estadosDeOcorrencia;

    public void setFaunaFlora(String faunaFlora) {
        this.faunaFlora = faunaFlora;
    }

    public String getFaunaFlora() {
        return faunaFlora;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getFamilia() {
        return familia;
    }

    public void setEspecieSimplificado(String especieSimplificado) {
        this.especieSimplificado = especieSimplificado;
    }

    public String getEspecieSimplificado() {
        return especieSimplificado;
    }

    public void setNomeComum(String nomeComum) {
        this.nomeComum = nomeComum;
    }

    public String getNomeComum() {
        return nomeComum;
    }

    public void setCategoriadeAmeaca(String categoriadeAmeaca) {
        this.categoriadeAmeaca = categoriadeAmeaca;
    }

    public String getCategoriadeAmeaca() {
        return categoriadeAmeaca;
    }

    public void setSiglaCategoriadeAmeaca(String siglaCategoriadeAmeaca) {
        this.siglaCategoriadeAmeaca = siglaCategoriadeAmeaca;
    }

    public String getSiglaCategoriadeAmeaca() {
        return siglaCategoriadeAmeaca;
    }

    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    public String getBioma() {
        return bioma;
    }

    public void setPrincipaisAmeacas(String principaisAmeacas) {
        this.principaisAmeacas = principaisAmeacas;
    }
    public String getPrincipaisAmeacas() {
        return principaisAmeacas;
    }

    public void setPresencaEmAreasProtegidas(String presencaEmAreasProtegidas) {
        this.presencaEmAreasProtegidas = presencaEmAreasProtegidas;
    }

    public String getPresencaEmAreasProtegidas() {
        return presencaEmAreasProtegidas;
    }

    public void setPlanodeAcaoNacionalparaConservacaoPAN(String planodeAcaoNacionalparaConservacaoPAN) {
        this.planodeAcaoNacionalparaConservacaoPAN = planodeAcaoNacionalparaConservacaoPAN;
    }

    public String getPlanodeAcaoNacionalparaConservacaoPAN() {
        return planodeAcaoNacionalparaConservacaoPAN;
    }

    public void setOrdenamentoPesqueiro(String ordenamentoPesqueiro) {
        this.ordenamentoPesqueiro = ordenamentoPesqueiro;
    }

    public String getOrdenamentoPesqueiro() {
        return ordenamentoPesqueiro;
    }

    public void setNiveldeProtecaoNaEstrategiaNacional(String niveldeProtecaoNaEstrategiaNacional) {
        this.niveldeProtecaoNaEstrategiaNacional = niveldeProtecaoNaEstrategiaNacional;
    }

    public String getNiveldeProtecaoNaEstrategiaNacional() {
        return niveldeProtecaoNaEstrategiaNacional;
    }

    public void setEspecieExclusivaDoBrasil(String especieExclusivaDoBrasil) {
        this.especieExclusivaDoBrasil = especieExclusivaDoBrasil;
    }

    public String getEspecieExclusivaDoBrasil() {
        return especieExclusivaDoBrasil;
    }

    public void setEstadosDeOcorrencia(String estadosDeOcorrencia) {
        this.estadosDeOcorrencia = estadosDeOcorrencia;
    }

    public String getEstadosDeOcorrencia() {
        return estadosDeOcorrencia;
    }

    public String toString() {
        return 
        "," + getBioma() +
        "," + getCategoriadeAmeaca() + 
        "," + getEspecieExclusivaDoBrasil() + 
        "," + getEspecieSimplificado() + 
        "," + getEstadosDeOcorrencia() + 
        "," + getFamilia() + 
        "," + getFaunaFlora() + 
        "," + getGrupo() + 
        "," + getNiveldeProtecaoNaEstrategiaNacional() + 
        "," + getNomeComum() + 
        "," + getOrdenamentoPesqueiro() + 
        "," + getPlanodeAcaoNacionalparaConservacaoPAN() +
        "," + getPresencaEmAreasProtegidas() + 
        "," + getPrincipaisAmeacas() + 
        "," + getSiglaCategoriadeAmeaca() + 
        ",";
    }

    public String[] getValuesAsArray() {
        return new String[] {
            bioma,
            categoriadeAmeaca,
            especieExclusivaDoBrasil,
            especieSimplificado,
            estadosDeOcorrencia,
            familia,
            faunaFlora,
            grupo,
            niveldeProtecaoNaEstrategiaNacional,
            nomeComum,
            ordenamentoPesqueiro,
            planodeAcaoNacionalparaConservacaoPAN,
            presencaEmAreasProtegidas,
            principaisAmeacas,
            siglaCategoriadeAmeaca
        };

    }

}