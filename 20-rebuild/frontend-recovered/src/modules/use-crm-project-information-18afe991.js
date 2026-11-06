import { useStore as n } from "vuex";
import { computed as e } from "vue";
import { watch as c } from "vue";
const i = (r) => {
  const t = n(), o = e(() => t.state.crm.projectInformationLoaded);
  if (o.value || t.dispatch("crm/fetchProjectInformation"), r) {
    const a = c(o, (m) => {
      m && setTimeout(() => {
        r(), a();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: o, projectInformationMap: e(() => t.state.crm.projectInformationMap) };
};
export {
  i as u
};
