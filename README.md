# Quarkus Multi-module project

This project uses [Quarkus](https://quarkus.io/), the Supersonic Subatomic Java Framework.

It serves as demo how to use Quarkus in a multi-module project with a Maven reactor and a Maven parent project.
Once packaged each module can be used on its own. The demo partially takes advantage of VSCode's task management

## Modules

| Module   | Type    | Port | Debug | Purpose                                                         |
| -------- | ------- | :--: | :---: | --------------------------------------------------------------- |
| root     | pom     | n/a  |  n/a  | Maven reactor, defining all modules                             |
| parent   | pom     | n/a  |  n/a  | Maven parent, with properties, dependency and plugin management |
| library1 | jar     | n/a  |  n/a  | Collection on POJO classes 1, no main function                  |
| library2 | jar     | n/a  |  n/a  | Collection on POJO classes 1, no main function                  |
| service1 | quarkus | 8080 | 5005  | Web endpoint for `/hello`                                       |
| service2 | quarkus | 8081 | 5006  | More web endpoints and webUI                                    |

## Goals

- Ability to create indenpendent (micro)services 1 & 2
- Ability to test services independent **and** together

## Take note

- properties are defined in `parent`, try to avoid defining them in other modules
- Maven reactor and Maven parent a separated, usually you find them muddled together
- **ALL** dependency **versions** are defined in the parent's `<dependencyManagement>` element. This includes default configurations for a dependency
- **ALL** plugin **versions** are defined in the parent's `<pluginManagement>` element. This includes default configurations for a plugin
- Each quarkus app has a profile associated with it. Only the profile contains the `quarkus-maven-plugin`
- Each quarkus app needs to run in its own shell, see below
- When building the final output, you need to specify all profiles, so `quarkus-maven-plugin` can run its magic
- Run `mvn clean` separately to avoid clearing out classes that might be in use

## Shell

The commands to run `quarkus:dev` that work in any Ide, each in its own terminal:

- `mvn compile quarkus:dev -Pservice1`
- `mvn compile quarkus:dev -Pservice2`

In VSCode you want to use a task (see below)

## Debugging

The project contains a sample `launch.json` that allows to attach to either service1 or service2

## Environment

- Tested on macOS, Ubuntu, devContainers
- VSCode & Maven in current version

## VSCode Task

There are 4 tasks defined:

- `clear` to run `mvn clear`
- `Run service1`
- `Run service2`
- `Run solution` : That's what you avtually run triggering parallel execution of service1 and service2

You can create a keyboard shortcut. Shortcuts can't be defined on a per project basis, so you add this to your user setting's shortcut file:

```json
[
  {
    "key": "ctrl+0",
    "command": "workbench.action.tasks.runTask",
    "args": "Run solution"
  }
]
```

## Feedback

- Open an issue
- reach out on [mastodon](https://chaos.social/@stw)

YMMV
