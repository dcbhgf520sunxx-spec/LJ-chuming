import { _ as C, j1 as k, ec as f, j0 as N } from "../../../../../../shared/runtime.js";
import { inject as u } from "vue";
import { ref as a } from "vue";
import { watchEffect as A } from "vue";
import { watch as B } from "vue";
import { provide as v } from "vue";
import { openBlock as n } from "vue";
import { createBlock as c } from "vue";
import { withCtx as R } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as V } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as L } from "vue";
import { defineAsyncComponent as P } from "vue";
import { ElDivider as S } from "element-plus";
import { ElDrawer as M } from "element-plus";
import O from "./module/DrawerLeft.vue.js";
import "../../../../../../modules/index-a8127339.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
import "../../../../../../modules/useTableHeight-90797a0b.js";
import "../../../../../../modules/index-d4be09aa.js";
const z = { class: "report-container" }, q = { __name: "index", props: { visible: { type: Boolean } }, emits: ["update:visible"], setup(y, { expose: w, emit: h }) {
  const j = P(() => N(() => import("./module/DrawerRight.vue.js"), ["static/js/DrawerRight-7959117f.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/index-a8127339.js", "static/css/DrawerRight-01db2e29.css"])), l = y, { formData: p } = u("selfParentData"), d = a("MATERIALS_COST"), s = a([]), { projectInfo: r } = u("tableItem"), D = a();
  A(async () => {
    const { project: t } = r.value;
    t.id && await x(t.id);
  });
  async function x(t) {
    let e = await k.get("/api/project/v2/selfSupportCost", { projectId: t, year: p.value.year });
    e.signingDate = e.signDate, e = [e], e[0] = { ...e[0], ...e[0].project }, e[0].projectName = e[0].serialNumber + " - " + e[0].shortName, e[0].materialExpenditure = f(e[0].materialExpenditure), s.value = f(e);
  }
  const I = h, b = () => {
    I("update:visible", false);
  }, i = a(0);
  return B(() => l.visible, (t) => {
    t && (i.value = Math.random());
  }, { immediate: true }), v("reportInfo", s), v("common", { radioType: d, reportInfo: s, costItemInfo: D }), w({ radioType: d }), (t, e) => {
    const g = S, E = M;
    return n(), c(E, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": l.visible, "show-close": false, "with-header": false, "destroy-on-close": "", size: "100%" }, { default: R(() => {
      var m, _;
      return [T("div", z, [(n(), c(O, { key: i.value, class: "drawer-left" })), V(g, { class: "direction", direction: "vertical" }), (_ = (m = o(r)) == null ? void 0 : m.project) != null && _.id ? (n(), c(o(j), { key: i.value, "project-info": o(r), year: o(p).year, class: "drawer-right", onClose: b }, null, 8, ["project-info", "year"])) : L("", true)])];
    }), _: 1 }, 8, ["model-value"]);
  };
} }, W = C(q, [["__scopeId", "data-v-5a13ed15"]]);
export {
  W as default
};
