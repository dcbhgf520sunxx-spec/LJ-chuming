import { useStore as n } from "vuex";
import { computed as e } from "vue";
import { watch as a } from "vue";
import { a3 as o } from "../shared/runtime.js";
const r = (l) => {
  const t = n(), i = e(() => t.state.config.loaded.sectionAll);
  if (i.value || t.dispatch("config/fetchSectionAll"), l) {
    const s = a(i, (c) => {
      c && setTimeout(() => {
        l(), s();
      }, 0);
    }, { immediate: true });
  }
  return { sectionAll: e(() => t.state.config.sectionAll), artifactSectionAll: e(() => t.state.config.sectionAll[o.ARTIFACT.V]), assembleSectionAll: e(() => t.state.config.sectionAll[o.ASSEMBLE.V]), partSectionAll: e(() => t.state.config.sectionAll[o.MACHINE_PART.V]), auxiliaryMaterialAll: e(() => t.state.config.sectionAll[o.AUXILIARY_MATERIAL.V]), loaded: i };
};
export {
  r as u
};
