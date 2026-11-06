import { useStore as C } from "vuex";
import { ref as v } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as n } from "vue";
import { withDirectives as D } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as E } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as S } from "element-plus";
import { x as L, ay as l, o as B, az as _, G as N, an as R } from "../../../../shared/runtime.js";
import { c as V } from "../../../../modules/cutting-config-4fe0051a.js";
import P from "./module/header.vue.js";
import T from "./module/form.vue.js";
const A = { class: "app-container" }, J = { class: "head-container" }, j = { __name: "index", setup(M) {
  const g = C(), b = { add: true, edit: false, del: false, download: false }, d = v(), { crud: r, CRUD: p, columns: c } = L({ title: "零件下料配置", sort: [], optShow: { ...b }, permission: { ...l }, crudApi: { ...V }, hasPagination: false }, d), { maxHeight: x } = B({ extraBox: [".head-container"], paginate: false });
  p.HOOK.afterSubmit = () => {
    u();
  }, p.HOOK.afterDelete = () => {
    u();
  };
  function u() {
    g.commit("config/SET_LOADED", { key: "bridgeCutConfigs", loaded: false });
  }
  return (K, U) => {
    const a = H, w = f("table-cell-tag"), y = f("common-table"), k = S;
    return t(), O("div", A, [h("div", J, [n(P)]), D((t(), i(y, { ref_key: "tableRef", ref: d, data: e(r).data, "highlight-current-row": "", "empty-text": e(r).emptyText, "max-height": e(x), style: { width: "100%" }, "row-key": "id" }, { default: m(() => [n(a, { label: "序号", type: "index", align: "center", width: "60" }), e(c).visible("name") ? (t(), i(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "切割形式", align: "center", "min-width": "120px" }, { default: m(({ row: o }) => [n(w, { name: e(_).VL[o.boolNestCutEnum], color: e(_).V[o.boolNestCutEnum].COLOR, offset: 15 }, null, 8, ["name", "color"]), h("span", null, E(o.name), 1)]), _: 1 })) : s("", true), e(c).visible("thickness") ? (t(), i(a, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: "支持板厚(mm) ≤", align: "center", "min-width": "120px" })) : s("", true), e(c).visible("cuttingHolesJoint") ? (t(), i(a, { key: "cuttingHolesJoint", prop: "cuttingHolesJoint", "show-overflow-tooltip": true, label: "切孔联割(φ) ≥", align: "center", "min-width": "120px" })) : s("", true), e(N)([...e(l).edit, ...e(l).del]) ? (t(), i(a, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: m((o) => [n(e(R), { data: o.row, permission: e(l) }, null, 8, ["data", "permission"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[k, e(r).loading]]), n(e(T))]);
  };
} };
export {
  j as default
};
