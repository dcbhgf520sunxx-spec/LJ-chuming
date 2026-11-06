import p from "./module/header.vue.js";
import f from "./module/table.vue.js";
import { u } from "../../../../../modules/useSelect-654af12a.js";
import { useStore as _ } from "vuex";
import { ref as r } from "vue";
import { provide as d } from "vue";
import { watch as h } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as S } from "vue";
import { createVNode as s } from "vue";
import "../../../../../shared/runtime.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/self-healing-29154caf.js";
import "../../../../../modules/contract-9b18cc88.js";
import "../../../../../modules/useTableTotal-3d22365a.js";
const w = { class: "app-container" }, E = { __name: "index", setup(y, { expose: l }) {
  const n = _(), c = r({ settlementStatus: "", year: (/* @__PURE__ */ new Date()).getTime() }), { projectLeaderList: i } = u(), o = r(null), a = r(null), m = r({});
  return d("selfParentData", { formData: c, headerRef: o, tableRef: a, projectLeaderList: i, _commonFn: m }), h(() => n.state.approval_list.isRefresh, (t) => {
    var e;
    t && ((e = a.value) == null || e.getSelfProjectList());
  }, { deep: true }), l({ refresh: async () => {
    var t, e;
    await ((t = a.value) == null ? void 0 : t.getSelfProjectList()), await ((e = o.value) == null ? void 0 : e.getSelfEmployed());
  } }), (t, e) => (v(), S("div", w, [s(p, { ref_key: "headerRef", ref: o }, null, 512), s(f, { ref_key: "tableRef", ref: a }, null, 512)]));
} };
export {
  E as default
};
