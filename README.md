# Dissertation
Dissertation Android App

This application was developed as a thesis for troubleshooting users' privacy on android devices.<br/>
A proxy is implemented that controls the incoming and outgoing traffic and in case of personal data breach, the corresponding traffic gets intercepted and blocked.

Elements considered to be personal data:
<ol>
<li>Phone number</li>
<li>IMEI</li>
<li>IMSI</li>
<li>Geographical location</li>
<li>Subscriber Id</li>
<li>Carrier Name</li>
<li>Mac Address</li>
</ol>

A notification system has also been implemented for the user to be notified in case of personal data exfiltration, and the option of allowing or blocking it, is prompted. The selection is stored and can be managed later via the corresponding interface.

Also, a Trusted Access Point Storage System has been implemented for the user to connect only to trusted access points with a specified BSSID. It can also be managed via its corresponding interface.

Finally, statistics about applications and personal data are being collected, so that basic starting settings can be imported at first startup.
