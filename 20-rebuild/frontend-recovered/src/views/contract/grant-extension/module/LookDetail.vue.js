import { ref as g } from "vue";
import { inject as D } from "vue";
import { watch as N } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as e } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as d } from "vue";
import { unref as i } from "vue";
import { toDisplayString as y } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as v } from "vue";
import { createElementVNode as C } from "vue";
import { ElButton as L } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { ElTag as A } from "element-plus";
import { ElTable as H } from "element-plus";
import { ElDrawer as I } from "element-plus";
import { o as q, ec as M, dp as R, iv as U, eb as j } from "../../../../shared/runtime.js";
import { e as z } from "../../../../modules/grant-managment-2c540b60.js";
import { u as G } from "../../../../modules/useTableTotal-3d22365a.js";
const F = { class: "detail-container" }, P = { key: 0 }, $ = { key: 1 }, X = { __name: "LookDetail", setup(J, { expose: x }) {
  const n = g(false), m = g([]), k = D("tableItem"), { maxHeight: w } = q({ mianBox: [".el-drawer__body"], extraBox: [".el-drawer__header"], paginate: true });
  N(() => n.value, (o) => {
    o && _();
  });
  const { requestData: c, total: p, getSummaries: E } = G(false, { defineData: ["useAmount"] }), _ = async () => {
    try {
      const o = await z({ ...c, creditId: k.value.id });
      m.value = M(o.content), p.value = o.totalElements;
    } catch (o) {
      console.error("获取使用记录失败" + o);
    }
  };
  return x({ visible: n }), (o, a) => {
    const T = L, l = S, f = A, V = H, B = I;
    return r(), u("div", F, [e(B, { modelValue: n.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => n.value = t), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, size: "45%" }, { header: s(() => [e(R, { "type-one": false, "header-title": "使用记录" }), e(T, { plain: "", size: "default", onClick: a[0] || (a[0] = (t) => n.value = false) }, { default: s(() => a[2] || (a[2] = [d("关闭")])), _: 1, __: [2] })]), default: s(() => [e(V, { data: m.value, "max-height": i(w), "summary-method": i(E), border: "", "show-summary": "" }, { default: s(() => [e(l, { align: "center", label: "序号", type: "index", width: "80" }), e(l, { align: "center", label: "日期", prop: "createTime" }), e(l, { align: "center", label: "采购单号", prop: "purchaseNumber", "show-overflow-tooltip": "" }, { default: s(({ row: t }) => [t.purchaseNumber ? (r(), u("span", P, y(t.purchaseNumber), 1)) : (r(), u("span", $, "-"))]), _: 1 }), e(l, { align: "center", label: "金额", prop: "useAmount" }), e(l, { align: "center", label: "类型", prop: "isStatus" }, { default: s(({ row: t }) => [t.isStatus === 0 ? (r(), h(f, { key: 0, type: "danger" }, { default: s(() => a[3] || (a[3] = [d("支出")])), _: 1, __: [3] })) : v("", true), t.isStatus === 1 ? (r(), h(f, { key: 1, type: "success" }, { default: s(() => a[4] || (a[4] = [d("还款")])), _: 1, __: [4] })) : v("", true)]), _: 1 }), e(l, { align: "center", label: "剩余额度", prop: "residueAmount" }), e(l, { align: "center", label: "付款事由" }, { default: s(({ row: t }) => {
      var b;
      return [C("span", null, y((b = i(U).V[t.paymentReasonId]) == null ? void 0 : b.L), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"]), e(j, { "request-data": i(c), total: i(p), onHandleChange: _ }, null, 8, ["request-data", "total"])]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  X as default
};
