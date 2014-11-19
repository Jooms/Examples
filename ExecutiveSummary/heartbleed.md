Heartbleed
==========
**Your boss comes to you and says, "While I was driving in to work, on the radio they mentioned some virus or something called Heartbleed. I'm worried about our website. Look into it and report back to me on it." and he forwards you this news article: [Heartbleed is about to get worse, and it will slow the internet to a crawl](http://www.washingtonpost.com/blogs/the-switch/wp/2014/04/14/heartbleed-is-about-to-get-worse-and-it-will-slow-the-internet-to-a-crawl/). Investigate the issue (not just this one article) and write an executive summary to explain the matter to your boss, along with suggestions.**

Executive Summary I
-------------------
Together, as a team, the four of us have looked into the impact of the Heartbleed vulnerability on our systems. Heartbleed is a vulnerability caused by poorly written security code in OpenSSL (a highly used security library). It leaks information to the attacker. We have patched our servers so that they are no longer vulnerable. We now use LibreSSL instead of OpenSSL, which has none of the vulnerabilities.

Executive Summary II
--------------------
The Heartbleed bug aﬀects a vast amount of web servers, which in turn aﬀect all of the users of these servers. Speciﬁcally, it is a bug found in the OpenSSL library that is treated as an industry standard; in other words, it is used almost everywhere. We must be sure to take the necessary precautions against this bug, and follow the prescribed remedies.

Common Vulnerabilities + Exploits, or CVE for short, catalog exploits from around the world and oﬀer ﬁxes. For this speciﬁc vulnerability, the ﬁx is simple; update OpenSSL to the latest version, and the vulnerability will be gone. System administrators have reported that updating OpenSSL will not aﬀect day-to-day server operations, so it is a simple process that will result in minimal downtime.

Executive Summary III
---------------------
If the site is using Open SSL service, then we need to patch the whole that heartbleed makes, and change our security keys and passwords. Otherwise you don’t have to do anything. We will do a quick fix that will patch the major vulnerabilities to protect the site certificate. If we do have to change the security keys, it will take customers longer to get into the site, because they have to update the security keys.

Executive Summary IV
--------------------
The Heartbleed bug is a serious security threat to our website. A malicious entity could easily get the certificates to our website and use them to misrepresent us. This is a huge legal and business problem since we could potentially be liable for the security flaw and lose business in the process. I recommend we fix our website by upgrading our servers to the new version of SSL. This will protect us from this bug and ensure we do not get hacked. In the meantime it would be wise to alert our users and look into shutting the website down until it is upgraded to prevent any attacks.

Heartbleed is negatively impacting websites across the internet, and we want to take action to prevent ours from being part of this. We can fix it by upgrading our version of SSL, and this will protect us from damages both legal and financial.

Executive Summary V
-------------------
* Purpose/Goal
  * Update security information
  * Update Software
* Findings
  * Security risks
  * Certificate theft
  * User information leaks
  * Website can be duplicated
* Recommendation
  * Update client information
  * Update Software to remedy Heartbleed bug
  * Update anything that uses SSL
  * Reevaluate website certificate
  * Reestablish the website’s key
* Conclusion
  * Poor programming practices led to security risks amongst modern hacking society.
  * Isure security and authenticity of the website,reevaluating for the Heartbleed bug.

Executive Summary VI
--------------------
**Purpose of Study**

The need for secure, encrypted data communication across the internet is vital for users and businesses alike. To be able to handle user accounts, payment information, and privacy, all security measures must be taken and tested to ensure their proper functionality.

With the recent discovery of the Heartbleed bug, the concern for the aforementioned variables has increased greatly. With the services our website provides, it is crucial to check our security implementations and verify that all data is safe and secure.

**Findings and General Recommendations**

We determined that our website was vulnerable to the Heartbleed bug, and therefore issued emails to all users to change their passwords in case they were stolen, as well as update their account security (i.e. security questions).

We recommend implementing two-factor authentication for all users, as another measure of trying to protect data and block any nefarious actions by unknown parties. Also, on our end, we need to update our website security certificates.

**Key Recommendation**

All users must be contacted via emailed and asked to change their account passwords and
update other security information. The best plan for a user to insure their privacy of data is:
  * Change their passwords, update their account details.
  * Add two factor authentication
  * Clear all security certificates so that they may be replaced with new, secure ones

On our end, we should verify all security measures and test our certificates and user – database interactions for any potential security issues.