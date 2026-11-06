import { m as a } from "../shared/runtime.js";
import { watch as m } from "vue";
function l(o, r = "projectId") {
  const { globalProjectId: e } = a("globalProjectId");
  return m(e, (t) => {
    o.query[r] = t;
  }, { immediate: true }), e;
}
export {
  l as u
};
