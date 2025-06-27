package DependencyInjection.Code;

interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        // Simulate fetching from a database
        return "Customer{id='" + id + "', name='John Doe'}";
    }
}

class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void displayCustomer(String id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Found: " + customer);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        service.displayCustomer("C101");
    }
}
