import { provide as P } from "vue";
import { inject as E } from "vue";
import { ref as V } from "vue";
import { watch as j } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as s } from "vue";
import { createBlock as d } from "vue";
import { withCtx as f } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as I } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementBlock as $ } from "vue";
import { Fragment as R } from "vue";
import { renderList as z } from "vue";
import { createTextVNode as G } from "vue";
import { toDisplayString as K } from "vue";
import { isRef as Q } from "vue";
import { ElMessageBox as X } from "element-plus";
import { ElMessage as J } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElSwitch as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { l as u, x as ee, u as te, o as ae, aS as l, G as k, an as ie, cX as oe } from "../../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
import se from "./module/form.vue.js";
import le from "./module/batch-form.vue.js";
import { e as re } from "../../../../../modules/specification-config-4ae0bc64.js";
function ce(a) {
  return u({ module: "config", url: "classification/material/section-steel/specification", method: "get", params: a });
}
function de(a) {
  return u({ module: "config", url: "classification/material/section-steel/specification", method: "post", data: a });
}
function ue({ sectionSteelId: a, list: m }) {
  return u({ module: "config", url: `classification/material/section-steel/${a}/specification/batch`, method: "post", data: m });
}
function me(a) {
  return u({ module: "config", url: "classification/material/section-steel/specification", method: "put", data: a });
}
function fe(a) {
  return u({ module: "config", url: "classification/material/section-steel/specification", method: "delete", data: a });
}
function we({ sectionSteelId: a, standardId: m }) {
  return u({ module: "config", url: `classification/material/section-steel/${a}/standard/${m}/specification`, method: "get" });
}
const pe = { get: ce, add: de, edit: me, del: fe, batchAdd: ue }, p = "unitNet_", he = { __name: "index", props: { visible: { type: Boolean, required: true } }, emits: ["update:visible"], setup(a, { emit: m }) {
  const T = m;
  P("prefix", p);
  const A = a, B = { batchAdd: true, add: true, edit: false, del: true, download: false }, h = oe, F = E("standard"), g = E("sectionSteel"), w = V(), x = V(), { CRUD: U, crud: c, columns: S } = ee({ title: "型材规格", formStore: true, formStoreKey: "CONFIG_SECTION_STEEL_SPEC_DETAIL", permission: { ...h }, optShow: { ...B }, crudApi: { ...pe }, requiredQuery: ["id"], hasPagination: false }, x), { visible: _, handleClose: L } = te({ emit: T, props: A, field: "visible", showHook: N }), { maxHeight: H } = ae({ mainBox: ".section-steel-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => w.value.loaded);
  U.HOOK.handleRefresh = (o, { data: n }) => {
    Array.isArray(n.content) && n.content.forEach((i) => {
      Array.isArray(i.standard) && i.standard.forEach((b) => {
        i[`${p}${b.id}`] = b.unitNet;
      });
    });
  };
  function N() {
    g.value.id && (c.query.id = g.value.id, c.toQuery());
  }
  function O(o, n) {
    try {
      X.confirm(`是否要${n ? "启用" : "禁用"}此规格`, "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
        await re([o.id], { status: o.status });
      }).catch(() => {
        o.status = o.status === l.TRUE.V ? l.FALSE.V : l.TRUE.V, J({ type: "info", message: `取消${n ? "启用" : "禁用"}` });
      });
    } catch (i) {
      console.log("申购单状态", i), o.status = o.status === l.TRUE.V ? l.FALSE.V : l.TRUE.V;
    }
  }
  return j(() => _.value, (o) => {
    o && (c.query.specification = void 0);
  }, { deep: true }), (o, n) => {
    const i = W, b = Y, D = C("common-table"), M = C("common-drawer"), q = Z;
    return s(), d(M, { ref_key: "drawerRef", ref: w, modelValue: e(_), "onUpdate:modelValue": n[0] || (n[0] = (t) => Q(_) ? _.value = t : null), "before-close": e(L), size: 1e3, title: e(g).name ? `${e(g).name}规格列表` : "型材规格列表", "custom-class": "section-steel-detail", direction: "rtl" }, { content: f(() => [r(e(ne)), I((s(), d(D, { ref_key: "tableRef", ref: x, data: e(c).data, "max-height": e(H), "show-empty-symbol": false, "return-source-data": "", onSelectionChange: e(c).selectionChangeHandler }, { default: f(() => [r(i, { align: "center", type: "selection", width: "55" }), r(i, { align: "center", label: "序号", type: "index", width: "60" }), e(S).visible("specification") ? (s(), d(i, { key: "specification", "show-overflow-tooltip": true, align: "center", label: "规格", prop: "specification", width: "150" })) : y("", true), e(S).visible("status") ? (s(), d(i, { key: "status", "show-overflow-tooltip": true, align: "center", label: "状态", prop: "status" }, { default: f(({ row: t }) => [r(b, { modelValue: t.status, "onUpdate:modelValue": (v) => t.status = v, "active-value": e(l).TRUE.V, disabled: !e(k)(e(h).editStatus), "inactive-value": e(l).FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (v) => O(t, t.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })) : y("", true), (s(true), $(R, null, z(e(F), (t) => (s(), $(R, { key: t.id }, [e(S).visible(`${p}${t.id}`) ? (s(), d(i, { key: 0, label: `${t.name}
理论重量(kg/m)`, prop: `${p}${t.id}`, "show-overflow-tooltip": true, align: "center", "min-width": "120" }, { default: f((v) => [G(K(v.row[`${p}${t.id}`]), 1)]), _: 2 }, 1032, ["label", "prop"])) : y("", true)], 64))), 128)), e(k)(e(h).edit) ? (s(), d(i, { key: 2, align: "center", fixed: "right", label: "操作", width: "100px" }, { default: f((t) => [r(e(ie), { data: t.row, permission: e(h), "show-del": false }, null, 8, ["data", "permission"])]), _: 1 })) : y("", true)]), _: 1 }, 8, ["data", "max-height", "onSelectionChange"])), [[q, e(c).loading]]), r(e(se)), r(e(le))]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, xe = Object.freeze(Object.defineProperty({ __proto__: null, default: he }, Symbol.toStringTag, { value: "Module" }));
export {
  he as _,
  ue as b,
  we as g,
  xe as i
};
