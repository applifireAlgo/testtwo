package test.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import test.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import test.app.server.repository.LoginRepository;
import test.app.shared.authentication.Login;
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
import test.app.shared.contacts.CoreContacts;
import test.app.server.repository.CoreContactsRepository;
import test.app.shared.contacts.Gender;
import test.app.server.repository.GenderRepository;
import test.app.shared.location.Language;
import test.app.server.repository.LanguageRepository;
import test.app.shared.location.Timezone;
import test.app.server.repository.TimezoneRepository;
import test.app.shared.contacts.Title;
import test.app.server.repository.TitleRepository;
import test.app.shared.authentication.User;
import test.app.server.repository.UserRepository;
import test.app.shared.authentication.UserAccessDomain;
import test.app.server.repository.UserAccessDomainRepository;
import test.app.shared.authentication.UserAccessLevel;
import test.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(122);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("obakUtHwH4GGHte2GvrunZ1z1pAaNY6TruLn6vNR2KpnnORUhw");
            corecontacts.setFirstName("DXPB0LiGDlbkjQtCUofNmrVuJdshAj75h7I3sBcjPXW5srmjif");
            Gender gender = new Gender();
            gender.setGender("EgjeWLaoG3mj1xmOfXjE1aTh0efRVv7rQaP8W8VsTMZhihX62R");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Xn");
            language.setAlpha3("AcL");
            language.setAlpha4("gXbv");
            language.setAlpha4parentid(11);
            language.setLanguage("tOliaom2kPsDLGr9mC657AlFgjaNS8mND3wBm5zANbEKtOqH0X");
            language.setLanguageDescription("A3L3Xrmn7pNwdAKoXez3I771JDuHrLpNdnwIqSa0nO22YuYeSb");
            language.setLanguageIcon("0KK9C2zAGFNGpcO6cdUpxYARi7ikHNQQblKzrpWHxvFHWCnLal");
            language.setLanguageType("HNDvdmqx66PhoFPnOrRcedzPXpVbyTRO");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("rpyEn7zo8mKhBbcbf905VOxBxjGMKqJQDv2JFf6EmpRj5v5b19");
            timezone.setCountry("byFY9zYGuNYmv8GqLXMv1VV5dTxtHzaMNxApiEqbVb4q3OCNd6");
            timezone.setGmtLabel("hrSnJSuEfejUALw2BoLHxX9kQIs1bR0nV1QwxKwq4jzxXuAxHc");
            timezone.setTimeZoneLabel("WaAWyIcNKC1RW1IfUhybrfzHXJ5xO87Zy7l6ZdFmwBgisOxzJO");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("ibionCjPWDE775IrpVK9NxZ9HcsoX1MR0QINVcQ4HC8AQh3xFV");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(101);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("HmwJ328DsT8FmOUuQbXOAQWhNxqDRm2sDPZQNPEf4gpN3x8X5c");
            corecontacts.setFirstName("VKQyeHRenhZwUydEXEj9Md2xV0OwdousiBEhipY77jhcwY88kC");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("5kE38uhP0tWbRb2u61R3Irueq6RYugEZMlUfcjrr913bbjwysD");
            corecontacts.setMiddleName("nA1UTXO6FXjLeubXdF631BQi88B6BXuNvYWbZTucTEV1QbTh0P");
            corecontacts.setNativeFirstName("hbyCHAOQBsNsfdEnEfWzUovQZw7wMqxth5eaL38JQcE4lj8hBm");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("th7heEPs5CiFBeeKT46BLR3kEIgYSw9KosswJmmtfRfOJZd248");
            corecontacts.setNativeMiddleName("b4vfU6s484bADvAoGE1KxhF2s7IwN4fQKwnSsbqss7d7qCTEPX");
            corecontacts.setNativeTitle("eR3M4IzFMb81bXgmjoHHd0mpO4joTay1gbpzyykBv5hVD0bEWR");
            corecontacts.setPhoneNumber("qzy1mafrRYtf0quE0sCX");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("DtjyD5eybqgJ0W0h2zbsW62qySo7ibDDEabURvTFVH1jmra6WW");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(218);
            user.setUserAccessCode(8);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("wjBDxwf7jBBFXJ348FCbRqGc2MzL7E8w3zLmyfEF2ds3t4nz2U");
            useraccessdomain.setDomainHelp("NLYAfazUea0qKu14gc9LqTfbTjCi8qIO8weJgo7faOPUGpbd8e");
            useraccessdomain.setDomainIcon("p8H6w9wWj9jPbUfTZ7yHD11sBsemrMA6RVdt79PL1wfjGXrfWn");
            useraccessdomain.setDomainName("TOimOs9X7e93kkW9EBgR54gb4gJWZM0aVpL5bS6SWEbvkYPwNZ");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("10C7ghTSmoSnWKEawR2C9Dc8Nihe2ahG35w6xHPOaiaVpGhK4m");
            useraccesslevel.setLevelHelp("HePCRrQOpDsa7wIQKbCxPBlPPspvT4jahIxY8ju6mL4Rn4C3E7");
            useraccesslevel.setLevelIcon("IZBsnmrsNNLL5KcmBibj3VMxSNM2XnOtFANKciS1QKxQA2afCp");
            useraccesslevel.setLevelName("RJ7X6fqpLf7nTTvnDrs5fTDjOsN8yCpDn8CIikHaoHvzpYmWCx");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("F9Nlsr0UEpe1NHW1CpuvIrrNaWPcmVw8UOeLdkenL3CGJUy6PI");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(992);
            user.setUserAccessCode(8);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(1);
            login.setIsAuthenticated(true);
            login.setLoginId("FEDHY42Zo5uhnJdUhFU2jhq9RLBKLiUMqEhpUZdwdtRccmTv7E");
            login.setServerAuthImage("fj5TtFBMxatZSDWvgDdKaiJYgwyHRJPC");
            login.setServerAuthText("E2kNNjaHPNOcQSzL");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(4);
            login.setLoginId("VAWghBlmOPgDm6HoQTUub6IR7f0ltOGHbl1u8wisWUYP4jDTJB");
            login.setServerAuthImage("XOafiEbtJyhW9mzy5SzTq2dBVujdlImq");
            login.setServerAuthText("1k8QizjoI6IwEFdO");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
