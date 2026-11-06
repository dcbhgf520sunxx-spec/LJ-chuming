import { inject as B } from "vue";
import { ref as g } from "vue";
import { computed as h } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as C } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as H } from "vue";
import { ElMessageBox as $ } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { InfoFilled as K } from "@element-plus/icons-vue";
import { ElIcon as Y } from "element-plus";
import { ElTooltip as G } from "element-plus";
import { ElSwitch as W } from "element-plus";
import { vLoading as z } from "element-plus";
import { c as J, e as Q, m as X } from "./module/form.vue.js";
import { l as m, o as Z, x as ee, ed as p, D as te, eg as ae, ee as ne, G as b, aS as u, an as oe } from "../../../../../shared/runtime.js";
import { b as ie } from "../../../../../modules/base-6bc46ddf.js";
import se from "./module/header.vue.js";
function re(n) {
  return m({ url: "api/system/project-coating-config/list", method: "get", params: n });
}
function le(n) {
  return m({ url: "api/system/project-coating-config", method: "post", data: n });
}
function ce(n) {
  return m({ url: "api/system/project-coating-config", method: "put", data: n });
}
function ue(n) {
  return m({ url: `api/system/project-coating-config/${n}`, method: "delete" });
}
function de(n) {
  return m({ url: "api/system/project-coating-config/update-status", method: "put", params: n });
}
const me = { get: re, add: le, edit: ce, del: ue }, pe = { class: "app-container" }, fe = { class: "head-container" }, ge = { style: { display: "inline-block" } }, Ce = { __name: "index", setup(n) {
  const o = B("projectData"), w = g(), y = g(), E = g(), { maxHeight: S } = Z({ paginate: true }), V = h(() => o ? me : J), T = h(() => o ? de : Q), k = { add: true, edit: false, del: false, download: false }, { crud: l, CRUD: f } = ee({ title: "涂装配置", sort: [], permission: { ...p }, optShow: { ...k }, crudApi: { ...V.value }, dataPath: "", hasPagination: false }, w), M = h(() => [["price", ["to-thousand", te.YUAN]]]);
  async function P(a, c) {
    try {
      await $.confirm('此操作将 "' + u.VL[c] + '" ' + a.artifactClassificationNameList + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await T.value({ id: a.id, status: c }), l.refresh(), l.notify(u.VL[c] + "成功", f.NOTIFICATION_TYPE.SUCCESS);
    } catch (s) {
      console.log("变更涂装配置状态", s), a.status = a.status === u.TRUE.V ? u.FALSE.V : u.TRUE.V;
    }
  }
  async function A() {
    try {
      const a = await ie() || {};
      E.value = a;
    } catch (a) {
      console.log("创建涂装配置方式", a);
    }
  }
  return A(), f.HOOK.beforeRefresh = (a, c) => {
    o && (a.query.projectId = o == null ? void 0 : o.contractProjectId, a.dataPath = "content");
  }, f.HOOK.beforeToAdd = () => {
    o && (l.form.contractProjectId = o == null ? void 0 : o.contractProjectId);
  }, (a, c) => {
    const s = q, I = K, L = Y, F = G, N = W, U = R("common-table"), j = z;
    return _(), D("div", pe, [d("div", fe, [t(e(se), { measurementManner: y.value }, null, 8, ["measurementManner"])]), O((_(), C(U, { ref_key: "tableRef", ref: w, data: e(l).data, "empty-text": e(l).emptyText, "data-format": M.value, "max-height": e(S), style: { width: "100%" }, "row-key": "id", onSelectionChange: e(l).selectionChangeHandler }, { default: r(() => [t(s, { label: "序号", type: "index", align: "center", width: "60" }), t(s, { key: "artifactClassificationNameList", prop: "artifactClassificationNameList", "show-overflow-tooltip": true, label: "构件类型", align: "center", "min-width": "100px" }), t(s, { key: "paintType", prop: "paintType", "show-overflow-tooltip": true, label: "油漆类型", align: "center", "min-width": "100px" }, { default: r(({ row: i }) => [d("span", null, x(e(ae).VL[i.paintType]), 1)]), _: 1 }), t(s, { key: "measurementManner", prop: "measurementManner", "show-overflow-tooltip": true, label: "计量方式", align: "center", "min-width": "140px" }, { default: r(({ row: i }) => [d("span", null, x(e(ne).VL[i.measurementManner]), 1)]), _: 1 }), t(s, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价（元/吨）", align: "center", "min-width": "100px" }), t(s, { key: "status", prop: "status", label: "状态", align: "center", width: "80px" }, { header: r(() => [t(F, { class: "item", effect: "light", content: "", placement: "top" }, { default: r(() => [d("div", ge, [c[0] || (c[0] = d("span", null, "状态", -1)), t(L, null, { default: r(() => [t(I)]), _: 1 })])]), _: 1 })]), default: r((i) => [t(N, { modelValue: i.row.status, "onUpdate:modelValue": (v) => i.row.status = v, disabled: !e(b)(e(p).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(u).TRUE.V, "inactive-value": e(u).FALSE.V, onChange: (v) => P(i.row, i.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 }), e(b)([...e(p).edit, ...e(p).del]) ? (_(), C(s, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: r((i) => [t(e(oe), { data: i.row }, null, 8, ["data"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height", "onSelectionChange"])), [[j, e(l).loading]]), t(e(X), { measurementManner: y.value }, null, 8, ["measurementManner"])]);
  };
} };
export {
  Ce as default
};
