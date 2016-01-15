package test.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import test.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import test.app.server.repository.CoreContactsRepository;
import test.app.shared.contacts.CoreContacts;
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
import test.app.shared.contacts.Gender;
import test.app.server.repository.GenderRepository;
import test.app.shared.location.Language;
import test.app.server.repository.LanguageRepository;
import test.app.shared.location.Timezone;
import test.app.server.repository.TimezoneRepository;
import test.app.shared.contacts.Title;
import test.app.server.repository.TitleRepository;
import test.app.shared.location.Address;
import test.app.server.repository.AddressRepository;
import test.app.shared.location.AddressType;
import test.app.server.repository.AddressTypeRepository;
import test.app.shared.location.City;
import test.app.server.repository.CityRepository;
import test.app.shared.location.Country;
import test.app.server.repository.CountryRepository;
import test.app.shared.location.State;
import test.app.server.repository.StateRepository;
import test.app.shared.contacts.CommunicationData;
import test.app.shared.contacts.CommunicationGroup;
import test.app.server.repository.CommunicationGroupRepository;
import test.app.shared.contacts.CommunicationType;
import test.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("Q72MRelLZAZeeUJ5OaBFraPgwfP6fysaojBr8oYugTzJxkXZeK");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("lW");
            language.setAlpha3("eXX");
            language.setAlpha4("K1Np");
            language.setAlpha4parentid(8);
            language.setLanguage("uHowx69A7LJlINbHsSWznONewx2nCEgP5Z90Ii7ExBIrcnM08j");
            language.setLanguageDescription("CPXY5NVrjeTw0BvIGuf4yJGdQNAXUqsvTsvWciaMqSGv8XN2m6");
            language.setLanguageIcon("qVFCPGyd06N48qiUQyFgs7aFfqKVROJjz8zzcCC6vLDfQMy1Q5");
            language.setLanguageType("JbA7rIroDN6eN95yaxu4vSca1qOMyVEZ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("WZsgV9ufqXqroXWtIdViFhh2tyg1jkwuqK2kV18VhKc2p4MnGY");
            timezone.setCountry("4ZTz5fNqEhwLc0bWCaWFnLcVMw2Qqu90YGTbDgV0FaJOD5OEo0");
            timezone.setGmtLabel("QFWUXMkkKADpAZ8jRAo58tNmsSrKOB60hJUf8IF0A32HjFQ5xu");
            timezone.setTimeZoneLabel("sfQJm9AMSww1sP31hgUdjzG1J6B4CKAQ7TL3Waq9Aggn35wW28");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("gdB5FxE1hdvYqtIDYvTJsWa1J3numegIH8k8FE2rysLTeTE0Km");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(99);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("8U5BdZjFByrrC4EGTCyS0k6BDQKEoE3pX0KbVPPWfq4vy0zBad");
            corecontacts.setFirstName("Bb4E6FstMTHDIWNdDk2SoRgfM7l6dKpJu2PSVTYwJREgoW2PH3");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("cpIRhmidickAKRzpERrF0TdMR39JpHrDfb26vkjrGbTxjE1FVT");
            corecontacts.setMiddleName("9DeZYNvVt1nhcE4HDhLTGfc4Ut2030mZK0zOBztPGsYR2n1Nz4");
            corecontacts.setNativeFirstName("KBXbZysjAU0DrRGGT8n4mccPw2LMBQEe9W6I3vbXrTr9wgN49e");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("UwXoRdd4fwkxWM0rWCPzNfTmyU6EfqI6JmGWsujdccgQXXjyaF");
            corecontacts.setNativeMiddleName("AiEYiySnl8yLMN3tApYgfyAHmTrnlszh5QhHx9nrfuGzRK0mcU");
            corecontacts.setNativeTitle("PTLrPEFWyxecrsGnEk6QoXqGThBuaE7N273FXcyyuhC3f8cyuJ");
            corecontacts.setPhoneNumber("VHCF71MXnL6eNlNfRvt9");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("lINwBPJ1uIwSNVXehCO76K3lSPMf9PUEZZx6TyzJOUUPPvN2BJ");
            address.setAddress2("yvQVtFvZqQfHPqWhsGiRbz2FfX5uRSZyszLjzKluRHfU6RT2ie");
            address.setAddress3("1hoy9Y51wmY4VJKRaGoCY3zRC8QzrQf67D6kDbnSa1OypFDuZN");
            address.setAddressLabel("NTU6BlFRG4L");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("GDwkkxYnFmSLZ5w0Jxsq5kTNOVEFm651aYalEUeCzrXtiuMT7b");
            addresstype.setAddressTypeDesc("5YwwqIzHTfEVVmx9dMeBSUjTc6wuQxgpJNZMAm59gX5PwBccFj");
            addresstype.setAddressTypeIcon("jHr8VvahAP6ksdk68xriCiqGSKmaJfqaBIIaBHXsF6rNqI4uqh");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("KEdhV8SADoRGmrUghulSvR1U1kefkIiW");
            city.setCityDescription("IifUlgu9Tk5iRAf3MDPMAXxzYlpHryPa9x41jVfzn3JlulWZAX");
            city.setCityFlag("IFJo1661mVwjqBDpzqGCSTitQnE0WuVk8O36oOBirCXcuagOO8");
            city.setCityLatitude(9);
            city.setCityLongitude(8);
            city.setCityName("MbA5HchECvfJqaMbVJA1XGiKYv4zRHCOmswvwYkWQErOnyVCc4");
            Country country = new Country();
            country.setCapital("CPHurZDJ5ni288WmwFU6iJ1mj33Sb6dM");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(0);
            country.setCountryCode1("iZL");
            country.setCountryCode2("DZy");
            country.setCountryFlag("kC53crRdoEaCCE99M6bLIH6A59GVh7bTUE09QDRiuzdbQV0oH1");
            country.setCountryName("qSJaXhkLWMV8Jn1WG5RJzoDkEYhl5EGmgx93r5NKT1cp3qmQfw");
            country.setCurrencyCode("R6X");
            country.setCurrencyName("LojCXvflvpYcd5AoBsUSxOMsQW9QRwpHVDh5CyFS5fhrAUjcH6");
            country.setCurrencySymbol("t20TH0BTw6wxZSqp7Mrb11H8OPGzEuAZ");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("Q8m63Ue2y4uoSwYStzeNq8BLeOtRuD6bfnCFXnXd1suMNtaYwN");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(10);
            state.setStateCode(0);
            state.setStateCodeChar2("v9P5Hew3pRPrp66khB3t6lskqgKuSVcR");
            state.setStateCodeChar3("aqw7Mozh4KLQk45oCDsqaUxTxor21fw1");
            state.setStateDescription("t8KgmRId8hTbrZ9f4Uo61xECw3SPhEUfkhufvChzifuYyh0cj2");
            state.setStateFlag("TOtINaqL0joGOgb6aJLApNKaMllU74OBcD7putHH9FJBn99mF3");
            state.setStateName("p7UWSJCHsOlNEkDnHMabw0lnmZJqEmp8Nzupf24ZGNRjj4Nojv");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("gHqUDUKdpT0anS7QfxkmbqSdfli6bAMi");
            city.setCityDescription("JMamEjWPILj1s4DL4MOpCGxVViEI3GPkKq7yd6qGVMbhzSElMG");
            city.setCityFlag("FerJdspTuJuYZaSGzsmqTspAHum9raXWAD0OhgIf0Jkur7koWr");
            city.setCityLatitude(8);
            city.setCityLongitude(6);
            city.setCityName("5VP8MiGq5EzL8vmctSgSfKGmlnGM5kTnSwRov6l9OvqNXZ6fXW");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("MVJhGlXzf31Noiq80VdzDgZUHWeMkpRBiElx8WrLVjtQUXtvyO");
            address.setAddress2("tcsvC8UmsJb1si487FszCLNdvcj4VqmWncbxu8q1OdEnHsFpyi");
            address.setAddress3("DmPWxVO2qS67WgFtzOw7sntnylwTxVljzC8ARpy4FOkCW0MfHq");
            address.setAddressLabel("uozUZoCaBcE");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("3loz8EfQ5qioxD927l4qEj8VSnjO3gwWYotPaqei5kYdRg4KyI");
            address.setLongitude("wZ69Fc8a5J0MARuIuda9aTd8t8zrkpK4UOXkBsYVjd5n3Ya9AO");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("HyPwGC");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("IWy");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("ua0xBkYq4yz0mzU3veBUdYZXqptPIhITRN0GCb4CohvZSgTCns");
            communicationgroup.setCommGroupName("K0v1Tn4oqpPePAMrdU2iE9UPdTTTIjzDaWw7T0CRfzb9S4iOWM");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("Za9S5wJB9ps5K0tnKxnz7Nva0FoqhvQ3QHEvbTxRoMzAHQsvqF");
            communicationtype.setCommTypeName("AMoje76wNDcpSWnRHruHHgB4r9RLCHXVE9nZ399WDf4WEkkpyj");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("6j9");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(15);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("aC7eMhyukb8bFgjqLTOckIRRizT6xL9rrZn7uEkC1PmYYxOoTk");
            corecontacts.setFirstName("gmZov9VDbkOMNRiSFkUWcTbSbCGef0qVeiAA3zFah0Ji2Nb4LN");
            corecontacts.setLastName("jr3lJ0eQTTM5DIsrqoyLd8cBi58hrgIEevryOIrzq1Z03xdOqm");
            corecontacts.setMiddleName("8tekGpesSVdGrQ5RkBqlGYlM3vanGtE2dFRHzfDWEhCgMstMaX");
            corecontacts.setNativeFirstName("gzAMcumSxtOTNVLBfThBBJUBz5QnKiLwh2HupgcHtwDEHvv7Dz");
            corecontacts.setNativeLastName("IYhdfv7ExEe3ocyrxL9PYNR0qRzotRB4CSPr1KS3I3ONiE2x0d");
            corecontacts.setNativeMiddleName("mH07O72kLsZ5qQTyGLMUL7wWklaph0sYPcRPQaVIYcaf7tVhQK");
            corecontacts.setNativeTitle("R2d5K0NgQnevdnVr7g8yoq1fq9Uqegf2cWWDHheikuannGHscS");
            corecontacts.setPhoneNumber("z2whQpt5ViSjRNRNq7Rn");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
