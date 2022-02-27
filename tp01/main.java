// EX 01 A


								// apenas parametriza classes genericas
								// aqui 
public class PriorityBufferPrinter <E extends Document> implements Iterable<E> {

	private final ArrayList<E> buffer;
	private final Integer maxSize;


	public PriorityBufferPrinter(Integer maxSize) {
		buffer = new ArrayList<>();
		this.maxSize = maxSize;
	}

	public boolean addDocument(E doc) {
		if(usedSize() + doc.getsize() > maxSize) return false;

		while(int i < buffer.size()) {
			// se a prioridade for maior
			if(buffer.get(i).compareTo(doc) > 0) {
				buffer.add(i, doc);
				return true;
			}
			i++;
		}

		buffer.add(doc);

		return true;
	}

}


// WARNING: Como apagar cenas dentro de um array list

public boolean delDocuments(int size) {
	boolean ret = false;
	Iterator<E> it = buffer.intrator();

	while(it.hasNext()) {
		E doc = it.next();
		if(doc.getSize() > size) {
			it.remove();
			ret = true;
		}
	}

	return ret;
}
























