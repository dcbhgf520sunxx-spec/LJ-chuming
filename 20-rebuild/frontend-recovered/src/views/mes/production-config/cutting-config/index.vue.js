import { ref as x } from "vue";
import { useStore as L } from "vuex";
import { resolveComponent as T } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as O } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as P } from "element-plus";
import { x as B, oN as h, o as N, G as R, an as E } from "../../../../shared/runtime.js";
import { c as $ } from "../../../../modules/cutting-config-c0cf91cc.js";
import { g as A } from "../../../../modules/production-machine-team -25d37afa.js";
import J from "./module/header.vue.js";
import K from "./module/form.vue.js";
const M = { class: "app-container" }, V = { class: "head-container" }, Q = { __name: "index", setup(U) {
  const r = x([]), b = L(), v = { add: true, edit: false, del: false, download: false }, _ = x(), { crud: c, CRUD: d, columns: g } = B({ title: "钻孔工艺配置", sort: [], optShow: { ...v }, permission: { ...h }, crudApi: { ...$ }, hasPagination: false }, _), { maxHeight: w } = N({ extraBox: [".head-container"], paginate: false });
  async function k() {
    const m = await A({});
    r.value = m;
  }
  k(), d.HOOK.afterSubmit = () => {
    y();
  }, d.HOOK.afterDelete = () => {
    y();
  }, d.HOOK.handleRefresh = (m, p) => {
    p.data.content = p.data.content.map((a) => a);
  };
  function y() {
    b.commit("config/SET_LOADED", { key: "cutConfigs", loaded: false });
  }
  return (m, p) => {
    const a = S, D = T("common-table"), H = P;
    return i(), C("div", M, [l("div", V, [o(J, { deviceTypeList: r.value }, null, 8, ["deviceTypeList"])]), O((i(), s(D, { ref_key: "tableRef", ref: _, data: e(c).data, "highlight-current-row": "", "empty-text": e(c).emptyText, "max-height": e(w), style: { width: "100%" }, "row-key": "id" }, { default: n(() => [o(a, { label: "序号", type: "index", align: "center", width: "60" }), e(g).visible("name") ? (i(), s(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "切割形式", align: "center", "min-width": "120px" }, { default: n(({ row: t }) => [l("span", null, u(t.cutTypeName), 1)]), _: 1 })) : f("", true), o(a, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: "支持板厚(mm) ≤", align: "center", "min-width": "120px" }, { default: n(({ row: t }) => [l("span", null, u(`${t.minThickness}~${t.maxThickness}`), 1)]), _: 1 }), o(a, { key: "boolDrillHole", prop: "boolDrillHole", label: "是否板孔联割", align: "center" }, { default: n(({ row: t }) => [l("span", null, u(t.boolDrillHole ? t.boolDrillHole === 1 ? "是" : "部分" : "否"), 1)]), _: 1 }), e(g).visible("cuttingHolesJoint") ? (i(), s(a, { key: "cuttingHolesJoint", prop: "cuttingHolesJoint", "show-overflow-tooltip": true, label: "切孔联割(φ) ≥", align: "center", "min-width": "120px" })) : f("", true), e(R)([...e(h).edit, ...e(h).del]) ? (i(), s(a, { key: 2, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n((t) => [o(e(E), { data: t.row }, null, 8, ["data"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, e(c).loading]]), o(e(K), { deviceTypeList: r.value }, null, 8, ["deviceTypeList"])]);
  };
} };
export {
  Q as default
};
