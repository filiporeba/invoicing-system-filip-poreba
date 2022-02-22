package pl.invoicing.db.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import pl.invoicing.db.Database;
import pl.invoicing.model.Invoice;

public class InMemoryDatabase implements Database {

  private final Map<Integer, Invoice> invoicesList = new HashMap<>();
  private int numberId = 1;

  @Override
  public int save(Invoice invoice) {
    invoice.setId(numberId);
    invoicesList.put(numberId, invoice);

    return numberId++;
  }

  @Override
  public Optional<Invoice> getById(int id) {
    return Optional.ofNullable(invoicesList.get(id));
  }

  @Override
  public List<Invoice> getAll() {
    return new ArrayList<>(invoicesList.values());
  }

  @Override
  public void update(int id, Invoice updatedInvoice) {
    if(!invoicesList.containsKey(id)) {
      throw new IllegalArgumentException();
    }

//    invoicesList.replace(id,updatedInvoice);
    updatedInvoice.setId(id);
    invoicesList.put(id,updatedInvoice);
  }

  @Override
  public void delete(int id) {
    invoicesList.remove(id);
  }
}
