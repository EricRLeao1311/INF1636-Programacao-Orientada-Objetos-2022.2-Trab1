package Model;

class Resposta{
	
  private Carta[] resposta;
  
  Resposta(Carta[] resposta){
    this.resposta = resposta;
  }
  
  static Carta[] criaResposta(Carta[] cartas) {
	    Carta resposta[] = new Carta[3];
	    int i = 0;
	    int suspeito = 0;
	    int arma = 0;
	    int comodo = 0;
	    while (i < 16 && (suspeito == 0 || arma == 0 || comodo == 0)) {

	      if (cartas[i].tipo == "Cômodo" && comodo == 0) {
	        resposta[0] = cartas[i];
	        System.arraycopy(cartas, i + 1, cartas, i, cartas.length - i - 1);
	        i -= 1;
	        comodo += 1;
	      }

	      else if (cartas[i].tipo == "Suspeito" && suspeito == 0) {
	        resposta[1] = cartas[i];
	        System.arraycopy(cartas, i + 1, cartas, i, cartas.length - i - 1);
	        i -= 1;
	        suspeito += 1;
	      }

	      else if (cartas[i].tipo == "Arma" && arma == 0) {
	        resposta[2] = cartas[i];
	        System.arraycopy(cartas, i + 1, cartas, i, cartas.length - i - 1);
	        i -= 1;
	        arma += 1;
	      }
	      i++;
	    }
	    return resposta;
	  }

  Carta[] getResposta() {
	  return resposta;
  }
  
}