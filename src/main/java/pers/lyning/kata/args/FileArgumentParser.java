package pers.lyning.kata.args;

import java.io.File;
import java.util.Optional;

/**
 * @author lyning
 */
public class FileArgumentParser implements ArgumentParser<Boolean> {

    private String args;

    @Override
    public Boolean parse(String args) {
        this.args = args;
        String filePath = this.getFileName().get();
        return new File(filePath).exists();
    }

    private Optional<String> getDir() {
        String flag = "-t";
        return this.get(flag);
    }

    private Optional<String> getFileName() {
        String flag = "-n";
        return Optional.ofNullable(this.getDir())
                .map(dir -> Optional.of(dir.get() + "/" + this.get(flag).get()))
                .orElse(this.get(this.getFlag()));
    }

    private Optional<String> get(String flag) {
        if (args.indexOf(flag) < 0) {
            return Optional.empty();
        }
        String[] argsArr = args.split(flag + " ");
        return Optional.of(argsArr[1].split(" ")[0]);
    }

    @Override
    public String getFlag() {
        return "-f";
    }
}
