import { ref as h } from "vue";
import { ElMessage as K } from "element-plus";
import { resolveComponent as b } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as p } from "vue";
import { createBlock as g } from "vue";
import { withCtx as n } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { createTextVNode as I } from "vue";
import { withDirectives as k } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementBlock as x } from "vue";
import { Fragment as Q } from "vue";
import { renderList as W } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElInputNumber as Y } from "element-plus";
import { InfoFilled as Z } from "@element-plus/icons-vue";
import { ElIcon as ee } from "element-plus";
import { ElTooltip as te } from "element-plus";
import { ElFormItem as oe } from "element-plus";
import { ElForm as ae } from "element-plus";
import { vLoading as ne } from "element-plus";
import { _ as le, t as re, o as se, ao as ie, i as D, jE as me, bV as E, S as pe, iy as ue, ba as de } from "../../../../../../shared/runtime.js";
import { _ as fe } from "../../../../../../modules/UploadBtn-b4cfb47a.js";
const ce = ["onDblclick"], _e = { __name: "form", props: { detailInfo: { type: Object, default: () => {
} } }, setup(V) {
  const { decimalPrecision: _ } = re(), v = h(), A = V, N = { applyAmount: void 0, attachmentIds: void 0, files: void 0, branchCompanyId: void 0, paymentReasonId: 1, supplierId: void 0, detailSaveParams: [] }, { maxHeight: S } = se({ wrapperBox: ".paymentAddForm", paginate: true, extraHeight: 120 }), { CRUD: T, crud: o, form: s } = ie(N, v), y = h(false), C = h(), F = { paymentDate: [{ required: true, message: "请选择付款日期", trigger: "change" }], paymentReasonId: [{ required: true, message: "请选择付款事由", trigger: "change" }], applyAmount: [{ required: true, validator: (i, a, l) => {
    D(a) || l(new Error("请填写申请金额")), l();
  }, trigger: "blur" }] }, R = h(false);
  function j(i) {
    C.value = i.id, y.value = true;
  }
  function B(i) {
    return de(i, { props: [["freight", _.value.supplyChain], ["paymentAmount", _.value.supplyChain], ["applyAmount", _.value.supplyChain]], toThousandFields: ["freight", "paymentAmount", "applyAmount"] });
  }
  return T.HOOK.beforeSubmit = () => {
    o.form.attachmentIds = o.form.files ? o.form.files.map((l) => l.id) : o.form.attachments ? o.form.attachments.map((l) => l.id) : void 0, o.form.supplierId = A.detailInfo.supplierId, o.form.branchCompanyId = A.detailInfo.branchCompanyId, o.form.applyAmount = 0;
    const i = JSON.parse(JSON.stringify(o.form.paymentDetails)), a = [];
    if (i.map((l) => {
      D(l.applyAmount) && (o.form.applyAmount += l.applyAmount, a.push(l));
    }), a.length === 0) return K.error("请填写本次申请明细"), false;
    o.form.paymentDetails = a;
  }, (i, a) => {
    const l = b("common-button"), u = X, M = Y, O = b("common-table"), U = Z, q = ee, z = te, H = oe, L = ae, $ = b("common-drawer"), P = G("show-thousand"), J = ne;
    return p(), g($, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(o).cancelCU, visible: t(o).status.cu > 0, title: t(o).status.title, "wrapper-closable": false, size: "50%" }, { titleRight: n(() => [r(l, { loading: t(o).status.cu === 2, type: "primary", size: "default", onClick: t(o).submitCU }, { default: n(() => a[2] || (a[2] = [I("提交审核")])), _: 1, __: [2] }, 8, ["loading", "onClick"])]), content: n(() => [r(L, { ref_key: "formRef", ref: v, model: t(s), rules: F, size: "default", "label-width": "60px", "label-position": "left" }, { default: n(() => [k((p(), g(O, { ref: "detailRef", border: "", data: t(s).paymentDetails, "max-height": t(S), style: { width: "100%", "margin-bottom": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": B }, { default: n(() => [r(u, { key: "projectName", prop: "projectName", label: "项目/采购合同编号", align: "center" }, { default: n((e) => [f("div", null, c(e.row.projectName || e.row.serialNumber), 1)]), _: 1 }), r(u, { key: "type", prop: "type", label: "运输属性", align: "center" }, { default: n((e) => [f("div", null, c(e.row.type ? t(me).VL[e.row.type] : "-"), 1)]), _: 1 }), r(u, { key: "freight", prop: "freight", label: "运费总额", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: n((e) => [f("div", null, c(t(E)(e.row.freight)), 1)]), _: 1 }), r(u, { key: "paymentAmount", prop: "paymentAmount", label: "已支付", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: n((e) => [f("div", null, c(t(E)(e.row.paymentAmount)), 1)]), _: 1 }), r(u, { key: "applyAmount", prop: "applyAmount", label: "本次支付金额(元)", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: n((e) => [k(r(M, { modelValue: e.row.applyAmount, "onUpdate:modelValue": (m) => e.row.applyAmount = m, modelModifiers: { number: true }, min: -9999999999, max: e.row.paymentAmount > e.row.freight ? 0 : e.row.freight - e.row.paymentAmount, step: 100, precision: t(_).supplyChain, placeholder: "本次支付(元)", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), [[P]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[J, R.value]]), r(H, { label: "附件" }, { label: n(() => {
      var e, m;
      return [a[3] || (a[3] = I(" 附件 ")), t(s).id && ((e = t(s).attachments) != null && e.length) && !((m = t(s).files) != null && m.length) ? (p(), g(z, { key: 0, effect: "light", content: "双击可预览附件", placement: "top" }, { default: n(() => [r(q, null, { default: n(() => [r(U)]), _: 1 })]), _: 1 })) : w("", true)];
    }), default: n(() => {
      var e, m;
      return [t(s).id && ((e = t(s).attachments) != null && e.length) && !((m = t(s).files) != null && m.length) ? (p(true), x(Q, { key: 0 }, W(t(s).attachments, (d) => (p(), x("div", { key: d.id }, [f("div", { style: { cursor: "pointer" }, onDblclick: (he) => j(d) }, c(d.name), 41, ce)]))), 128)) : w("", true), r(t(fe), { ref: "uploadRef", files: t(s).files, "onUpdate:files": a[0] || (a[0] = (d) => t(s).files = d), "file-classify": t(pe).CONTRACT_ATT.V, limit: 1, accept: ".jpg,.png,.pdf,.jpeg" }, null, 8, ["files", "file-classify"])];
    }), _: 1 })]), _: 1 }, 8, ["model"]), y.value ? (p(), g(ue, { key: 0, isVisible: y.value, showType: "attachment", id: C.value, onClose: a[1] || (a[1] = (e) => y.value = false) }, null, 8, ["isVisible", "id"])) : w("", true)]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ve = le(_e, [["__scopeId", "data-v-a83fd3de"]]);
export {
  ve as default
};
