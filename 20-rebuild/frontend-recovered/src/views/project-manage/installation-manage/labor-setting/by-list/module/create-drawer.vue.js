import { ref as r } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as c } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as t } from "vue";
import { unref as o } from "vue";
import { createTextVNode as K } from "vue";
import { createCommentVNode as C } from "vue";
import { withDirectives as X } from "vue";
import { createElementBlock as T } from "vue";
import { Fragment as j } from "vue";
import { toDisplayString as Y } from "vue";
import { isRef as Z } from "vue";
import { nextTick as ee } from "vue";
import { ElBadge as te } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElPagination as ae } from "element-plus";
import { vLoading as le } from "element-plus";
import { b as ne } from "../../../../../../modules/labor-setting-a0cbdb82.js";
import { tQ as h, u as re, J as ie, o as se, G as ce, c as ue, D as me } from "../../../../../../shared/runtime.js";
import { _ as de } from "../../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import pe from "./handle-confirm.vue.js";
import "../../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../../modules/index-8356a01a.js";
import "../../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
const ge = { class: "head-container" }, xe = { __name: "create-drawer", props: { modelValue: { type: Boolean, require: true }, globalProject: { type: Object, default: () => {
} }, globalProjectId: { type: Number, default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(s, { emit: I }) {
  const V = r(), i = r(h.ARTIFACT.V), S = r(), m = r(), d = r([]), x = I, N = s, { visible: p, handleClose: P } = re({ emit: x, props: N }), { handleSizeChange: z, handleCurrentChange: E, total: L, setTotalPage: R, queryPage: v } = ie({ fetchHook: w });
  Q(p, (l) => {
    l && w();
  }, { immediate: true });
  const k = r([]), B = r(), D = r(false), b = r(false), { maxHeight: A } = se({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, extraHeight: 70 });
  function U(l) {
    d.value = l;
  }
  async function w() {
    if (!m.value || !i.value) return;
    let l = [];
    try {
      const { content: e = [], totalElements: y } = await ne({ areaId: m.value, productType: i.value, ...v });
      l = e, R(y);
    } catch (e) {
      console.log(e, "获取可创建列表失败");
    } finally {
      k.value = l;
    }
  }
  function q({ monomerId: l, areaId: e }) {
    S.value = l, m.value = e, w();
  }
  async function M(l) {
    ee(async () => {
      var e;
      await ((e = V.value) == null ? void 0 : e.toggleRowSelection(l, false));
    });
  }
  function H() {
    x("success"), P();
  }
  return (l, e) => {
    const y = g("common-radio-button"), O = g("common-button"), F = te, a = oe, W = g("common-table"), $ = ae, G = g("common-drawer"), J = le;
    return c(), _(G, { ref_key: "drawerRef", ref: B, title: "清单创建", "close-on-click-modal": false, modelValue: o(p), "onUpdate:modelValue": e[3] || (e[3] = (n) => Z(p) ? p.value = n : null), direction: "rtl", "before-close": o(P), "destroy-on-close": "", "custom-class": "create-list-drawer", size: "80%" }, { content: u(() => [f("div", ge, [t(y, { modelValue: i.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => i.value = n), options: o(h).ENUM, type: "enum", class: "filter-item" }, null, 8, ["modelValue", "options"]), f("div", null, [t(o(de), { "project-id": s.globalProjectId, class: "filter-item", mainProductType: i.value, style: { width: "100%" }, onChange: q }, null, 8, ["project-id", "mainProductType"])]), f("div", null, [o(ce)(s.permission.summary) ? (c(), _(F, { key: 0, value: d.value.length, style: { float: "right", "margin-right": "10px" }, max: 99 }, { default: u(() => {
      var n;
      return [t(O, { type: "warning", size: "default", class: "filter-item", disabled: !((n = d.value) != null && n.length), onClick: e[1] || (e[1] = (fe) => b.value = true) }, { default: u(() => e[4] || (e[4] = [K(" 汇总 ")])), _: 1, __: [4] }, 8, ["disabled"])];
    }), _: 1 }, 8, ["value"])) : C("", true)])]), X((c(), _(W, { ref_key: "tableRef", ref: V, data: k.value, "max-height": o(A), stripe: false, onSelectionChange: U }, { default: u(() => [t(a, { type: "selection", align: "center", width: "60" }), t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), t(a, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), t(a, { prop: "specification", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), i.value === o(h).ARTIFACT.V ? (c(), T(j, { key: 0 }, [t(a, { prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }), t(a, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), t(a, { prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), t(a, { prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": "" }), t(a, { prop: "totalNetWeight", label: "总净重（kg）", align: "center", "show-overflow-tooltip": "" })], 64)) : C("", true), i.value === o(h).ENCLOSURE.V ? (c(), T(j, { key: 1 }, [t(a, { prop: "length", label: "单长（mm）", align: "center", "show-overflow-tooltip": "" }), t(a, { prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), t(a, { prop: "totalLength", label: "总长度（m）", align: "center", "show-overflow-tooltip": "" }, { default: u(({ row: n }) => [f("span", null, Y(n.totalLength ? o(ue)(n.totalLength, "mm", "m", o(me).COM_L__M) : 0), 1)]), _: 1 })], 64)) : C("", true)]), _: 1 }, 8, ["data", "max-height"])), [[J, D.value]]), t($, { total: o(L), "current-page": o(v).pageNumber, "page-size": o(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(z), onCurrentChange: o(E) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), t(pe, { modelValue: b.value, "onUpdate:modelValue": e[2] || (e[2] = (n) => b.value = n), selections: d.value, productType: i.value, areaId: m.value, permission: s.permission, globalProject: s.globalProject, globalProjectId: s.globalProjectId, onDelChange: M, onSuccess: H }, null, 8, ["modelValue", "selections", "productType", "areaId", "permission", "globalProject", "globalProjectId"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  xe as default
};
