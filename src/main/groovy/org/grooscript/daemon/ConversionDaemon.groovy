package org.grooscript.daemon

import static groovyx.gpars.dataflow.Dataflow.task

import org.grooscript.util.GsConsole

/**
 * User: jorgefrancoleza
 * Date: 21/02/13
 */
class ConversionDaemon {

    def source
    String destinationFolder
    Map conversionOptions = [:]
    def doAfter = null
    boolean recursive = false

    ConvertActor convertActor

    /**
     * Start the daemon
     * @return
     */
    public void start() {
        if (source && destinationFolder) {
            task {
                convertActor = new ConvertActor(source: source, destinationFolder: destinationFolder,
                    conversionOptions: conversionOptions, doAfter: doAfter, recursive: recursive).start()
                convertActor << source
            }.then {
                GsConsole.message('Daemon Started.')
            }
        } else {
            GsConsole.error('Daemon need source and destinationFolder to run.')
        }
    }

    /**
     * Stop the daemon if active
     * @return
     */
    public void stop() {
        if (convertActor && convertActor.isActive()) {
            convertActor << ConvertActor.FINISH
        } else {
            GsConsole.info('Stopping a non running daemon.')
        }
    }
}
