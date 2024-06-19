
# CIQDashboard JIRA+Zephyr(cloud) Collector

[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg?style=flat-square)](CODE_OF_CONDUCT.md)

![JDK version= 11](https://img.shields.io/badge/JDK-11-brightgreen?style=flat-square)
![MongoDB server version= 4.0 or above](https://img.shields.io/badge/MongoDB_Server-4.0_or_above-brightgreen?style=flat-square)
![Cloud](https://img.shields.io/badge/JIRA-Cloud-blue?style=flat-square)

[Requirements](#requirements) • [Properties](#properties) • [Run Locally](#run-locally) • [Contributing](#contributing) • [Related](#related)

The application fetches issues, test runs and related fields from JIRA and Zephyr Squad and stores them in a MongoDB database for use by other applications.

## Requirements

- JDK 11
- MongoDB Server 4.0 or above

## Properties

In order to run this project, you must provide the following values in application.yml which can be found under [resources](src/main/resources) directory

`MongoDB Server URI`

`JIRA Server base URL`

`JIRA Server Username`

`JIRA Server API Token`

`Zephyr Squad Server base URL`

`Zephyr Squad Server Access Key`

`Zephyr Squad Server Secret Key`

`Project Keys`

## Run Locally

Clone the project

```bash
  git clone https://github.com/CognizantCodeHub/ciqdashboard-collector-jira-zephyr-cloud.git
```

Go to the project directory

```bash
  cd ciqdashboard-collector-jira-zephyr-cloud
```

Build the project

```bash
  gradle build
```

Start the application

```bash
  gradle bootrun
```

## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.

## Related

Here are some related projects

[CIQDashboard UI](https://github.com/CognizantCodeHub/ciqdashboard-ui)

[CIQDashboard API](https://github.com/CognizantCodeHub/ciqdashboard-api)

[CIQDashboard Metric Services](https://github.com/CognizantCodeHub/ciqdashboard-metric-services)

[CIQDashboard Auth](https://github.com/CognizantCodeHub/ciqdashboard-auth)

[CIQDashboard ALM Collector](https://github.com/CognizantCodeHub/ciqdashboard-collector-alm)

[CIQDashboard Jira(on premise) Collector](https://github.com/CognizantCodeHub/ciqdashboard-collector-jira)

[CIQDashboard Jira(cloud) Collector](https://github.com/CognizantCodeHub/IPR000025_ciqdashboard-collector-jira-cloud)

[CIQDashboard Jira+Zephyr(On Premise) Collector](https://github.com/CognizantCodeHub/ciqdashboard-collector-jira-zephyr)

[CIQDashboard Rally Collector](https://github.com/CognizantCodeHub/ciqdashboard-collector-rally)

[CIQDashboard Jenkins Collector](https://github.com/CognizantCodeHub/ciqdashboard-collector-jenkins)

[CIQDashboard GitHub Collector](https://github.com/CognizantCodeHub/ciqdashboard-collector-github)

[CIQDashboard ServiceNow Collector](https://github.com/CognizantCodeHub/IPR000025_ciqdashboard-collector-servicenow)

## License

[To edit](https://choosealicense.com/licenses/)