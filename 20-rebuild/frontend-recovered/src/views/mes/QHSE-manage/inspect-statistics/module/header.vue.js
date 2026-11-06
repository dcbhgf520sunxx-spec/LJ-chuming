import p from "moment";
import { ref as c } from "vue";
import { computed as S } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as O } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withKeys as Q } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as B } from "vue";
import { withDirectives as K } from "vue";
import { createBlock as L } from "vue";
import { ElDatePicker as T } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElTag as $ } from "element-plus";
import { d as z, g as R, a as q } from "../../../../../modules/inspect-statistics-fca9b551.js";
import { mK as V, B as H, fv as M, aV as P, C as A, mJ as J, L as Y } from "../../../../../shared/runtime.js";
const Z = { __name: "header", setup(F) {
  const v = { date: [p().subtract(1, "months").valueOf(), p().valueOf()], startDate: p().subtract(1, "months").valueOf(), endDate: p().valueOf(), workShopId: void 0, status: V.ALL.V, insepectUserId: void 0, serialNumber: void 0, projectId: void 0 }, { crud: r, query: t, CRUD: w } = H(v), d = c([]), f = c(0), C = c([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), I = S(() => {
    var a, i, u;
    let o = [];
    if ((a = d.value) != null && a.length) if (t.workShopId && d.value.length) (i = d.value) == null || i.forEach((n) => {
      n.workshopId === t.workShopId && (o = n.inspectUsers || []);
    });
    else {
      const n = (u = d.value) == null ? void 0 : u.map((m) => m.inspectUsers);
      o = (n == null ? void 0 : n.flat()) || [];
    }
    return o;
  });
  function U() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), r.toQuery();
  }
  async function b(o) {
    try {
      d.value = await R();
    } catch (a) {
      console.log(a);
    }
  }
  b();
  async function k() {
    try {
      const o = await q(t);
      f.value = o || 0;
    } catch (o) {
      console.log(o);
    }
  }
  return w.HOOK.handleRefresh = async (o, { data: a }) => {
    k();
  }, (o, a) => {
    const i = T, u = h("common-radio-button"), n = h("common-select"), m = j, D = $, x = E("permission");
    return g(), N("div", null, [O("div", null, [s(i, { modelValue: e(t).date, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).date = l), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", "default-time": C.value, onChange: U }, null, 8, ["modelValue", "default-time"]), s(u, { modelValue: e(t).status, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).status = l), options: e(V).ENUM, type: "enum", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(e(M), { modelValue: e(t).projectId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).projectId = l), style: { width: "300px" }, filterable: "", clearable: "", class: "filter-item", placeholder: "项目搜索", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"])]), s(e(P), { modelValue: e(t).workShopId, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).workShopId = l), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), s(n, { modelValue: e(t).insepectUserId, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).insepectUserId = l), dataStructure: { key: "id", label: "name", value: "id" }, options: I.value, class: "filter-item", clearable: "", filterable: "", placeholder: "全部质检员", style: { width: "180px" }, type: "other", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(m, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).serialNumber = l), size: "default", placeholder: "编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: Q(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(A)), s(D, { class: "filter-item", size: "large" }, { default: y(() => [_("数量：" + B(f.value), 1)]), _: 1 }), K((g(), L(e(Y), { class: "filter-item", fn: e(z), params: e(t), "response-header-result": "" }, { default: y(() => a[6] || (a[6] = [_(" 下载 ")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[x, e(J).export]])]);
  };
} };
export {
  Z as default
};
