package Model;
public class Posicao {
	int x, y;
	public Posicao() {}
	public Posicao(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
