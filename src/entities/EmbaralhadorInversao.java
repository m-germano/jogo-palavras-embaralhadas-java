package entities;


public class EmbaralhadorInversao implements Embaralhador {
	

	@Override
	public String embaralhar(String palavra) {
		return new StringBuilder(palavra).reverse().toString();
	}

}