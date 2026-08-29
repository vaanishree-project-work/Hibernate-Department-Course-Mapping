package in.mecw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.mecw.entity.Address;
import in.mecw.entity.Student;
public class AddressDao {
	


	

		private EntityManagerFactory emf;

		public AddressDao(EntityManagerFactory emf) {
			this.emf = emf;
		}

		
		public String addAddress(Address address) {

			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();
			em.persist(address);
			et.commit();

			return "Address inserted";
		}

		
		public Address updateAddress(Address address) {

			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();
			address = em.merge(address);
			et.commit();

			return address;
		}

		
		public Address deleteAddress(Address address) {

			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();

			Address a = em.merge(address);
			em.remove(a);

			et.commit();

			return a;
		}

		
		public Address findAddressById(int id) {

			EntityManager em = emf.createEntityManager();

			return em.find(Address.class, id);
		}

		// Find All Addresses
		public List<Address> findAllAddresses() {

			EntityManager em = emf.createEntityManager();

			TypedQuery<Address> result =
					em.createQuery(
							"select a from Address a",
							Address.class);

			return result.getResultList();
		}

		
		public Address findAddressByStudent(int studentId) {

			EntityManager em = emf.createEntityManager();

			TypedQuery<Address> result =
					em.createQuery(
							"select s.address from Student s where s.studentId=:id",
							Address.class);

			result.setParameter("id", studentId);

			return result.getSingleResult();
		}

		
		public List<Student> findStudentsByCity(String city) {

			EntityManager em = emf.createEntityManager();

			TypedQuery<Student> result =
					em.createQuery(
							"select s from Student s where s.address.city=:city",
							Student.class);

			result.setParameter("city", city);

			return result.getResultList();
		}
	}