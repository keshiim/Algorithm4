//并查集，也是动态联通算法 http://blog.csdn.net/dm_vincent/article/details/7655764

public class UF {
	private int[] id;
	private int count;
	private int[] sz;
	
	public UF(int N) {
		//初始化分量id数组
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz = 1;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int find(int p) {
		return id[p];
	}
	
	public int find1(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	
	public int find2(int p) {
		//优化
		while (p != id[p]) {
			p = id[id[p]];
		}
		return p;
	}
	
	public void union(int p, int q) {
		//获取p和q的组号
		int pID = find(p);
		int qID = find(q);
		
		//如果两个组号相等，直接返回
		if (pID == qID) {
			return;
		}
		
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
		
		count --;
	}
	
	public void union1(int p, int q) {
		int pRoot = find1(p);
		int qRoot = find1(q);
		if (pRoot == qRoot) {
			return;
		}
		id[pRoot] = qRoot;
		count--;
	}
	
	public void union2(int p, int q) {
		int i = find2(p);
		int j = find2(q);
		if (i == j) {
			return;
		}
		//带权值比较
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
	
	public static void main(String[] args) {
		UF uf = new UF(Integer.getInteger(args[0]));
		
	}
}