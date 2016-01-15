package test.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import test.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import test.app.server.repository.AddressRepository;
import test.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import test.app.shared.location.AddressType;
import test.app.server.repository.AddressTypeRepository;
import test.app.shared.location.City;
import test.app.server.repository.CityRepository;
import test.app.shared.location.Country;
import test.app.server.repository.CountryRepository;
import test.app.shared.location.State;
import test.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("dyVXW3oacrJ3vP0JyQ94rJ5xWP7RnhsSYvC9g92SSvvEuqFkLT");
            addresstype.setAddressTypeDesc("5c4IA5O7KduBl1zlGV0ef2k2lkIkALmbLLNNGRnrQmgy6AOncx");
            addresstype.setAddressTypeIcon("7WeEUowhoi7euyuUKGl4QNFLnBMsdaAWlzCDB5AIEfhKGypBxl");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("X6KuX2qDXHNrbDcnHzhLQZpfIpqyoACB");
            city.setCityDescription("NY6dLQTgROIQC1aqxH20LNIQaISFC0vVbmJ5EzgQ2qfQUsT4G3");
            city.setCityFlag("vRF9aciRFhmsipaV7kJ6fa9BpEH98PGuloXqEEe2xWM9OHyXZQ");
            city.setCityLatitude(5);
            city.setCityLongitude(3);
            city.setCityName("DX2w80MQpQP4WKGcyP2ZK8Fnr8FUh0I7ebI6jjpm2U07R7qAEe");
            Country country = new Country();
            country.setCapital("xuAsVIK5jyY44IKj0dcHKxfI8cwmfRDG");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(5);
            country.setCountryCode1("aia");
            country.setCountryCode2("74k");
            country.setCountryFlag("V7c3STH5b8pxOuAGaBammI7AbYlYJiiy3hppivvFVIfHSIEjaI");
            country.setCountryName("9YCKOHXrnDpJ1wOJEg7SvQ1Shsv7iKvBsIZfDunWNgHUTJsYkF");
            country.setCurrencyCode("EIL");
            country.setCurrencyName("QsDAADm8g4gyPx2sPIYbiTaBvYjF8lAJ4tnMJmB3VeGLlsTrD0");
            country.setCurrencySymbol("rElL1Trg0R9POl1LagaNWpYtj23m2daL");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("Ea28TNhwszrNszh6LFIJCWBgkmbRPOzjoizsjgUhWUnVpG3tT5");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("A2Sjd2G923gGKDVJHOCidr4hqsQGW5AD");
            state.setStateCodeChar3("T1KI9ULSeTPLiHbhklNLWPUnRKTMu5Ra");
            state.setStateDescription("Zo4L1LioG5IFRshfnTd4TFNkeCUm8q150FC9BQVf4hWL2cYQNi");
            state.setStateFlag("8TsEOdI32qC2OCP7tubFxQv3pSuBIJrPG4tTfM7oppAaIKWwms");
            state.setStateName("73BoObnmnsegWolBY6swYPO1kZguLkR8xx1xeiAVvBXUBFjLz6");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("lHTToxMj7a8WA7CIj5BPBZZjV0R9diEZ");
            city.setCityDescription("J0faQ9dY0NrVnCQjfgEyz0gqEereqS7PK66UEXVUgRGZOnHe87");
            city.setCityFlag("aL6kdqBZckADTOc6GVIZzyqE7CRA2CiqIMHd3MtBdRl6Xq81Y3");
            city.setCityLatitude(0);
            city.setCityLongitude(8);
            city.setCityName("s4ur86ASbeKs2CITFZXLSU8vFdg4aZea0HOhePynVsfjQTM0ad");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("ANuiPKFU10pezoeLYFDcYBc0XyZF99OBiX8RJkTE6xR3OipIpu");
            address.setAddress2("hOlNI9QMZhFT8zLvVJxAZs3FNsMIhCYp0XHO0oPHasVIhm3FVk");
            address.setAddress3("gKO2Oaq8YacnZDvAdqwtBqhuqEQylXdIpwPThpe6uhVnqDH9AE");
            address.setAddressLabel("esvOFGLomBU");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("4SuP5Oae3ELn8gpylYm0P78tR6HiBeRnSgvoQMmiHbcVCMqbEe");
            address.setLongitude("3XHYI0Mq9hTu97hsssgE4Jh4DiizreNGejQN53hhocHCFkFo3B");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("7wW6aj");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("aEy5Y0Y8KE5TxVPmlmWqG8MgmZ06eCQnzIwMwcElUgEWGO4tNl");
            address.setAddress2("nRn4tDcZmb2GxbrwaNxLAsGG9ws3XvS9iFyEvoOZlRYpMlakZu");
            address.setAddress3("4yQDxClZm1JRB6jwah5qJNl45O0o4aStDGMZTsj35JMrM22ORk");
            address.setAddressLabel("fxkdk9VMZjS");
            address.setLatitude("z5cX1vH9NdiNa0wwAm5H4nQKb1UZ5julRwscGa3f6LB3f41t8K");
            address.setLongitude("IyKskYwflxejAx4U9aIhmC3Yh9CpIMQ63ziI6rWM7ymCEcQThR");
            address.setVersionId(1);
            address.setZipcode("7iNaFE");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
