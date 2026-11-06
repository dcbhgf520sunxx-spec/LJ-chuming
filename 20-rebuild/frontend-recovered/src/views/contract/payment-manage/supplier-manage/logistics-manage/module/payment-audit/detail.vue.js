import { ref as _ } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as a } from "vue";
import { createElementBlock as h } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as d } from "vue";
import { unref as o } from "vue";
import { createTextVNode as b } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as U } from "vue";
import { createElementVNode as m } from "vue";
import { Fragment as q } from "vue";
import { renderList as M } from "vue";
import { isRef as O } from "vue";
import { ElNotification as G } from "element-plus";
import { ElTag as K } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { InfoFilled as W } from "@element-plus/icons-vue";
import { ElIcon as X } from "element-plus";
import { ElTooltip as Y } from "element-plus";
import { ElFormItem as Z } from "element-plus";
import { ElForm as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { e as ae } from "../../../../../../../modules/pay-9ccccafb.js";
import { _ as oe, t as ne, o as le, u as ie, c3 as f, jE as se, bV as k, iy as ue, ba as re } from "../../../../../../../shared/runtime.js";
const ce = { key: 0 }, de = ["onDblclick"], me = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} }, modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 } }, emits: ["success", "update:modelValue"], setup(n, { emit: T }) {
  const { decimalPrecision: u } = ne(), x = _(), g = n, { maxHeight: C } = le({ wrapperBox: ".paymentAddForm", paginate: true, extraHeight: 40 }), y = _(false), I = _(), S = T, { visible: v, handleClose: V } = ie({ emit: S, props: g }), D = _(false);
  function N(r) {
    I.value = r.id, y.value = true;
  }
  function R(r) {
    return re(r, { props: [["freight", u.value.contract], ["paymentAmount", u.value.contract], ["applyAmount", u.value.contract]], toThousandFields: ["freight", "paymentAmount", "applyAmount"] });
  }
  async function E(r) {
    try {
      const t = { auditStatus: r, actuallyPaymentAmount: g.detailInfo.applyAmount, id: g.detailInfo.id };
      await ae(t), G({ title: "提交成功", type: "success" }), S("success"), V();
    } catch (t) {
      console.log("审核", t);
    }
  }
  return (r, t) => {
    const B = K, A = w("common-button"), p = Q, j = w("common-table"), z = W, F = X, P = Y, $ = Z, L = ee, H = w("common-drawer"), J = te;
    return i(), c(H, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(V), modelValue: o(v), "onUpdate:modelValue": t[3] || (t[3] = (e) => O(v) ? v.value = e : null), title: "审核详情", "wrapper-closable": false, size: "50%" }, { titleAfter: a(() => [n.detailInfo.receivingUnit ? (i(), h("span", ce, s(`物流公司:${n.detailInfo.receivingUnit}`), 1)) : d("", true), n.detailInfo.auditStatus ? (i(), c(B, { key: 1, size: "large", type: n.detailInfo.auditStatus === o(f).REJECT.V ? "info" : n.detailInfo.auditStatus === o(f).PASS.V ? "success" : "warning" }, { default: a(() => [b(s(n.detailInfo.auditStatus === o(f).REJECT.V ? "已驳回" : n.detailInfo.auditStatus === o(f).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : d("", true)]), titleRight: a(() => [n.showType === "audit" ? (i(), c(A, { key: 0, size: "default", type: "info", onClick: t[0] || (t[0] = (e) => E(o(f).REJECT.V)) }, { default: a(() => t[4] || (t[4] = [b("驳回")])), _: 1, __: [4] })) : d("", true), n.showType === "audit" ? (i(), c(A, { key: 1, size: "default", type: "success", onClick: t[1] || (t[1] = (e) => E(o(f).PASS.V)) }, { default: a(() => t[5] || (t[5] = [b("通过")])), _: 1, __: [5] })) : d("", true)]), content: a(() => [l(L, { ref_key: "formRef", ref: x, size: "default", "label-width": "60px", "label-position": "left" }, { default: a(() => [U((i(), c(j, { ref: "detailRef", border: "", data: n.detailInfo.paymentDetails, "max-height": o(C), style: { width: "100%", "margin-bottom": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": R }, { default: a(() => [l(p, { key: "projectName", prop: "projectName", label: "项目/采购合同编号", align: "center" }, { default: a((e) => [m("div", null, s(e.row.projectName || e.row.serialNumber), 1)]), _: 1 }), l(p, { key: "type", prop: "type", label: "运输属性", align: "center" }, { default: a((e) => [m("div", null, s(e.row.type ? o(se).VL[e.row.type] : "-"), 1)]), _: 1 }), l(p, { key: "freight", prop: "freight", label: "运费总额", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: a((e) => [m("div", null, s(o(k)(e.row.freight, o(u).contract)), 1)]), _: 1 }), l(p, { key: "paymentAmount", prop: "paymentAmount", label: "已支付", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: a((e) => [m("div", null, s(o(k)(e.row.paymentAmount, o(u).contract)), 1)]), _: 1 }), l(p, { key: "applyAmount", prop: "applyAmount", label: "本次支付金额(元)", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: a((e) => [m("div", null, s(o(k)(e.row.applyAmount, o(u).contract)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[J, D.value]]), l($, { label: "附件" }, { label: a(() => [t[6] || (t[6] = b(" 附件 ")), l(P, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: a(() => [l(F, null, { default: a(() => [l(z)]), _: 1 })]), _: 1 })]), default: a(() => [n.detailInfo.attachments && n.detailInfo.attachments.length > 0 ? (i(true), h(q, { key: 0 }, M(n.detailInfo.attachments, (e) => (i(), h("div", { key: e.id }, [m("div", { style: { cursor: "pointer" }, onDblclick: (fe) => N(e) }, s(e.name), 41, de)]))), 128)) : d("", true)]), _: 1 })]), _: 1 }, 512), y.value ? (i(), c(ue, { key: 0, isVisible: y.value, showType: "attachment", id: I.value, onClose: t[2] || (t[2] = (e) => y.value = false) }, null, 8, ["isVisible", "id"])) : d("", true)]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, be = oe(me, [["__scopeId", "data-v-569ae8c2"]]);
export {
  be as default
};
