package it.ferroz.lezioni;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

	
public class Main{
	public static void main(String[] args){
		System.out.println("Ciao");
		
		List<Integer> a = new ArrayList<Integer>();
		
	}
	
	public void aggiungi10(Collection<Integer> a){
		aggiungi(a, 10);
	}
	
	public void aggiungi(Collection<Integer> a, int n){
		for(int i = 0; i < n; ++i){
			a.add(i);
		}
	}
	
	public <T> void replica(Collection<T> a, int n, T x){
		for(int i = 0; i < n; ++i){
			a.add(x);
		}
	}
}