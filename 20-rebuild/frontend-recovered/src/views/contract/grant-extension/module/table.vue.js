import { inject as R } from "vue";
import { ref as s } from "vue";
import { provide as z } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as e } from "vue";
import { withCtx as d } from "vue";
import { unref as n } from "vue";
import { createBlock as p } from "vue";
import { createCommentVNode as f } from "vue";
import { Fragment as H } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElSwitch as M } from "element-plus";
import { ElButton as O } from "element-plus";
import { ElPopconfirm as j } from "element-plus";
import { ElTable as U } from "element-plus";
import { g as J, d as K, p as Q } from "../../../../modules/grant-managment-2c540b60.js";
import { o as W, G as m, eb as X, dq as Y, ec as Z, e2 as C } from "../../../../shared/runtime.js";
import ee from "./LookDetail.vue.js";
import { B as u } from "../../../../modules/contract-9b18cc88.js";
import { u as te } from "../../../../modules/useTableTotal-3d22365a.js";
const ce = { __name: "table", emits: ["editItem"], setup(ae, { expose: x, emit: D }) {
  const E = R("listFormData"), b = s(""), h = s([]), I = s(null), { requestData: _, total: y, getSummaries: v } = te(false, { defineData: ["lineOfCredit", "usedCredit", "remainingSum"] }), { maxHeight: S } = W({ paginate: true }), w = s(null), o = async () => {
    if (!m(u.get)) return b.value = "暂无权限";
    try {
      const { content: a, totalElements: i } = await J(Y({ ..._, ...E }));
      h.value = Z(a), y.value = i, v();
    } catch {
    }
  };
  o();
  const B = async (a) => {
    try {
      await K([a.id]), C("success", "删除成功"), await o();
    } catch {
    }
  }, G = D, N = (a) => {
    G("editItem", a);
  }, k = s();
  z("tableItem", k);
  const P = (a) => {
    k.value = a, w.value.visible = true;
  }, V = () => {
    o();
  };
  async function T(a) {
    const i = a.status === 0 ? 1 : 0;
    try {
      await Q({ id: a.id, status: a.status }), C("success", "状态修改成功"), await o();
    } catch {
      a.status = i;
    }
  }
  return x({ getGrantList: o }), (a, i) => {
    const t = L, $ = M, g = O, q = j, F = U;
    return c(), A(H, null, [e(F, { ref_key: "tableRef", ref: I, data: h.value, "empty-text": b.value, "max-height": n(S), "summary-method": n(v), border: "", fit: "", "show-summary": "" }, { default: d(() => [e(t, { align: "center", label: "序号", type: "index", width: "80" }), e(t, { align: "center", label: "创建日期", prop: "startDate" }), e(t, { align: "center", label: "创建人", prop: "userName" }), e(t, { align: "center", label: "被授信人姓名", prop: "accreditingPartyName" }), e(t, { align: "center", label: "身份证号码", "min-width": "160", prop: "idNumber" }), e(t, { align: "center", label: "项目", "min-width": "100", prop: "projectName", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "授信额度", "min-width": "100", prop: "lineOfCredit" }), e(t, { align: "center", label: "年息（%）", prop: "annualInterest" }), e(t, { align: "center", label: "已使用", prop: "usedCredit" }), e(t, { align: "center", label: "剩余额度", "min-width": "100", prop: "remainingSum" }), e(t, { align: "center", label: "有效期截止日", prop: "closingDate" }), e(t, { align: "center", label: "剩余天数", prop: "countDown" }), n(m)(n(u).toggle) ? (c(), p(t, { key: 0, align: "center", label: "状态", prop: "status" }, { default: d(({ row: l }) => [e($, { modelValue: l.status, "onUpdate:modelValue": (r) => l.status = r, "active-value": 0, "inactive-value": 1, "active-color": "#0FB55E", class: "header-switch", onClick: (r) => T(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "onClick"])]), _: 1 })) : f("", true), e(t, { align: "center", fixed: "right", label: "操作", width: "180" }, { default: d((l) => [n(m)(n(u).record) ? (c(), p(g, { key: 0, icon: "el-icon-view", size: "default", type: "info", onClick: (r) => P(l.row) }, null, 8, ["onClick"])) : f("", true), n(m)(n(u).edit) ? (c(), p(g, { key: 1, icon: "el-icon-edit", size: "default", type: "primary", onClick: (r) => N(l.row) }, null, 8, ["onClick"])) : f("", true), n(m)(n(u).del) ? (c(), p(q, { key: 2, "hide-icon": "", title: "确定删除本条数据吗?", onConfirm: (r) => B(l.row) }, { reference: d(() => [e(g, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "summary-method"]), e(X, { "request-data": n(_), total: n(y), onHandleChange: V }, null, 8, ["request-data", "total"]), e(ee, { ref_key: "detailRef", ref: w }, null, 512)], 64);
  };
} };
export {
  ce as default
};
