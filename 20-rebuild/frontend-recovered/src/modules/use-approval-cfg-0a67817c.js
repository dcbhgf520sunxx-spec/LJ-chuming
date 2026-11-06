import { useStore as s } from "vuex";
import { computed as t } from "vue";
import { watch as r } from "vue";
const c = (a) => {
  const o = s(), e = t(() => o.state.config.loaded.approvalCfg);
  if (o.state.config.loaded.approvalCfg || o.dispatch("config/fetchApprovalCfg"), a) {
    const f = r(e, (p) => {
      p && setTimeout(() => {
        a(), f();
      }, 0);
    }, { immediate: true });
  }
  return { approvalCfg: t(() => o.state.config.approvalCfg), loaded: t(() => o.state.config.loaded.approvalCfg) };
};
export {
  c as u
};
