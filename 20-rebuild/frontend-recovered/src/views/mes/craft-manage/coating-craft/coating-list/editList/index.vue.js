import { ref as d } from "vue";
import { inject as q } from "vue";
import { computed as H } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as u } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as O } from "vue";
import { unref as s } from "vue";
import { createBlock as T } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as K } from "vue";
import { ElTableColumn as M } from "element-plus";
import { InfoFilled as P } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElTooltip as j } from "element-plus";
import { ElInput as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { g as G } from "../../../../../../modules/coating-list-667107a8.js";
import { o as J, x as W } from "../../../../../../shared/runtime.js";
import X from "./module/detail.vue.js";
import Y from "./module/header.vue.js";
const Z = { style: { display: "inline-block" } }, ee = { key: 0 }, te = { key: 1 }, re = { __name: "index", props: { id: { type: Number, default: null } }, emits: ["checklist"], setup(f, { expose: k, emit: h }) {
  const w = f, v = h, x = { add: false, edit: false, del: false, download: false }, _ = d(), g = d(), c = d(false), { maxHeight: C } = J({ paginate: false }), { crud: l, CRUD: y } = W({ title: "涂装清单", optShow: { ...x }, crudApi: { get: G }, hasPagination: false }, _);
  y.HOOK.beforeToQuery = () => {
    l.query.id = w.id;
  };
  function V(n, o, t) {
    o.property === "surfaceArea" && !n.edit && (n.edit = true);
  }
  function A(n, o) {
    l.data[o].surfaceArea = n.surfaceArea;
  }
  function D(n) {
    g.value = n, c.value = true;
  }
  const N = q("getCoatingList");
  y.HOOK.afterRefresh = (n) => {
    v("checklist", n.data);
  };
  function B() {
    l.toQuery(), N();
  }
  return k({ dataList: H(() => l.data) }), (n, o) => {
    const t = M, E = P, I = Q, R = j, L = z, S = b("common-button"), U = b("common-table"), $ = F;
    return r(), u("div", null, [p("div", null, [e(Y)]), O((r(), T(U, { ref_key: "tableRef", ref: _, data: s(l).data, "empty-text": s(l).emptyText, "max-height": s(C), style: { width: "100%" }, "row-key": "id", onRowDblclick: V }, { default: i(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { key: "monomerName", prop: "monomerName", label: "单体", align: "center" }), e(t, { key: "areaName", prop: "areaName", label: "区域", align: "center" }), e(t, { key: "name", prop: "name", label: "名称", align: "center" }), e(t, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), e(t, { key: "specification", prop: "specification", label: "规格", align: "center" }), e(t, { key: "length", prop: "length", label: "长度（mm）", align: "center" }), e(t, { key: "material", prop: "material", label: "材质", align: "center" }), e(t, { key: "quantity", prop: "quantity", label: "数量", align: "center" }), e(t, { key: "surfaceArea", prop: "surfaceArea", label: "单件面积", align: "center" }, { header: i(() => [e(R, { class: "item", effect: "light", content: "双击可修改单件面积", placement: "top" }, { default: i(() => [p("div", Z, [o[1] || (o[1] = p("span", null, "单件面积(mm²)", -1)), e(I, null, { default: i(() => [e(E)]), _: 1 })])]), _: 1 })]), default: i((a) => [a.row.edit ? (r(), u("span", te, [e(L, { modelValue: a.row.surfaceArea, "onUpdate:modelValue": (m) => a.row.surfaceArea = m, onBlur: (m) => A(a.row, a.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])])) : (r(), u("span", ee, K(a.row.surfaceArea || "-"), 1))]), _: 1 }), e(t, { label: "操作", align: "center" }, { default: i((a) => [e(S, { icon: "el-icon-view", type: "primary", size: "default", onClick: (m) => D(a.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[$, s(l).loading]]), e(X, { modelValue: c.value, "onUpdate:modelValue": o[0] || (o[0] = (a) => c.value = a), rowData: g.value, craftId: f.id, onSuccess: B }, null, 8, ["modelValue", "rowData", "craftId"])]);
  };
} };
export {
  re as default
};
