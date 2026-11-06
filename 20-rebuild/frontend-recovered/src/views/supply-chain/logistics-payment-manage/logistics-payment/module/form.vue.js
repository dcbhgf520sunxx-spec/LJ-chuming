import { computed as $ } from "vue";
import { ref as A } from "vue";
import G from "moment";
import { ElMessage as J } from "element-plus";
import { resolveComponent as k } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as w } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as c } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as C } from "vue";
import { createElementBlock as Q } from "vue";
import { ElDivider as W } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElInputNumber as Z } from "element-plus";
import { ElFormItem as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { ElDatePicker as ae } from "element-plus";
import { ElInput as le } from "element-plus";
import { ElForm as oe } from "element-plus";
import { vLoading as ne } from "element-plus";
import { p as re } from "../../../../../modules/logistics-payment-1a755fb1.js";
import { _ as ie, t as se, ao as me, i as E, jE as ue, bV as R, ia as de, S as pe, ba as fe } from "../../../../../shared/runtime.js";
import { _ as ce } from "../../../../../modules/UploadBtn-b4cfb47a.js";
const ye = { key: 0 }, _e = { style: { color: "#82848a" } }, he = { __name: "form", props: { detailInfo: { type: Object, default: () => {
} } }, setup(s) {
  const { decimalPrecision: d } = se(), v = $(() => b.value.reduce((n, l) => {
    const f = Number(l == null ? void 0 : l.applyAmount);
    return isNaN(f) ? n : n + f;
  }, 0)), x = A(), h = s, P = { paymentDate: +G().startOf("day").valueOf(), applyAmount: void 0, attachmentIds: void 0, attachments: [], branchCompanyId: void 0, supplierId: void 0, detailSaveParams: [], remark: "" }, { CRUD: D, crud: i, form: p } = me(P, x), S = { paymentDate: [{ required: true, message: "请选择申请日期", trigger: "change" }], applyAmount: [{ required: true, validator: (n, l, f) => {
    E(l) || f(new Error("请填写申请金额")), f();
  }, trigger: "blur" }] }, I = A(false), b = A([]);
  async function j() {
    let n = [];
    I.value = true;
    try {
      const { content: l = [] } = await re({ supplierId: h.detailInfo.supplierId, branchCompanyId: h.detailInfo.branchCompanyId });
      n = l;
    } catch (l) {
      console.log("获取可付款列表失败", l);
    } finally {
      b.value = n, I.value = false;
    }
  }
  function U(n) {
    return fe(n, { props: [["freight", d.value.supplyChain], ["paymentAmount", d.value.supplyChain], ["applyAmount", d.value.supplyChain]], toThousandFields: ["freight", "paymentAmount", "applyAmount"] });
  }
  return D.HOOK.afterToAdd = () => {
    j();
  }, D.HOOK.beforeSubmit = () => {
    if (i.form.attachmentIds = i.form.attachments ? i.form.attachments.map((n) => n.id) : void 0, i.form.supplierId = h.detailInfo.supplierId, i.form.branchCompanyId = h.detailInfo.branchCompanyId, i.form.applyAmount = 0, i.form.detailSaveParams = [], b.value.map((n) => {
      E(n.applyAmount) && (i.form.applyAmount += n.applyAmount, i.form.detailSaveParams.push({ projectId: n.projectId, purchaseId: n.purchaseId, type: n.type, applyAmount: Number(n.applyAmount.toFixed(d.value.supplyChain)) }));
    }), i.form.detailSaveParams.length === 0) return J.error("请填写本次申请明细"), false;
  }, (n, l) => {
    const f = k("common-button"), N = W, y = X, B = Z, F = k("common-table"), m = ee, O = te, z = ae, L = le, M = oe, q = k("common-drawer"), H = V("show-thousand"), K = ne, g = V("thousand");
    return _(), w(q, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(i).cancelCU, visible: o(i).status.cu > 0, title: "新增付款申请", "wrapper-closable": false, size: "50%" }, { titleRight: t(() => [a(f, { loading: o(i).status.cu === 2, type: "primary", size: "default", onClick: o(i).submitCU }, { default: t(() => l[3] || (l[3] = [T("提交审核")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), content: t(() => [a(M, { ref_key: "formRef", ref: x, model: o(p), rules: S, size: "default", "label-width": "120px", "label-position": "right" }, { default: t(() => [a(N, null, { default: t(() => l[4] || (l[4] = [r("span", { class: "title" }, "金额汇总", -1)])), _: 1, __: [4] }), c((_(), w(F, { ref: "detailRef", border: "", data: b.value, "max-height": "230", style: { width: "100%", "margin-bottom": "10px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": U }, { default: t(() => [a(y, { key: "projectName", prop: "projectName", label: "项目/采购合同编号", align: "center" }, { default: t((e) => [r("div", null, u(e.row.projectName || e.row.serialNumber), 1)]), _: 1 }), a(y, { key: "type", prop: "type", label: "运输属性", align: "center" }, { default: t((e) => [r("div", null, u(e.row.type ? o(ue).VL[e.row.type] : "-"), 1)]), _: 1 }), a(y, { key: "freight", prop: "freight", label: "运费总额", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: t((e) => [r("div", null, u(o(R)(e.row.freight, o(d).supplyChain)), 1)]), _: 1 }), a(y, { key: "paymentAmount", prop: "paymentAmount", label: "已支付", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: t((e) => [r("div", null, u(o(R)(e.row.paymentAmount, o(d).supplyChain)), 1)]), _: 1 }), a(y, { key: "applyAmount", prop: "applyAmount", label: "本次支付金额(元)", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: t((e) => [e.row.freight !== e.row.paymentAmount ? c((_(), w(B, { key: 0, modelValue: e.row.applyAmount, "onUpdate:modelValue": (Y) => e.row.applyAmount = Y, modelModifiers: { number: true }, min: -9999999999, max: e.row.paymentAmount > e.row.freight ? 0 : e.row.freight - e.row.paymentAmount, step: 100, precision: o(d).supplyChain, placeholder: "本次支付(元)", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])), [[H]]) : C("", true)]), _: 1 })]), _: 1 }, 8, ["data"])), [[K, I.value]]), a(N, null, { default: t(() => l[5] || (l[5] = [r("span", { class: "title" }, "明细填报", -1)])), _: 1, __: [5] }), a(m, { label: "物流公司" }, { default: t(() => [r("span", null, u(s.detailInfo.supplierName), 1)]), _: 1 }), a(m, { label: "已付款" }, { default: t(() => [c(r("span", null, null, 512), [[g, s.detailInfo.paymentAmount]]), r("span", null, "（" + u(s.detailInfo.paymentRate) + "%）", 1)]), _: 1 }), a(m, { label: "已收票" }, { default: t(() => [c(r("span", null, null, 512), [[g, s.detailInfo.invoiceAmount]]), r("span", null, "（" + u(s.detailInfo.invoiceRate) + "%）", 1)]), _: 1 }), a(m, { label: "最后一次付款" }, { default: t(() => [s.detailInfo.lastPaymentAmount ? c((_(), Q("span", ye, null, 512)), [[g, s.detailInfo.lastPaymentAmount]]) : C("", true), s.detailInfo.lastPaymentTime ? (_(), w(O, { key: 1, style: { "margin-left": "5px" } }, { default: t(() => [T(u(n.parseTime(s.detailInfo.lastPaymentTime, "{y}-{m}-{d}")), 1)]), _: 1 })) : C("", true)]), _: 1 }), a(m, { label: "本次付款" }, { default: t(() => [c(r("span", null, null, 512), [[g, v.value]])]), _: 1 }), a(m, { label: "大写" }, { default: t(() => [r("span", _e, u(v.value ? o(de)(v.value) : ""), 1)]), _: 1 }), a(m, { label: "申请日期", prop: "paymentDate" }, { default: t(() => [a(z, { modelValue: o(p).paymentDate, "onUpdate:modelValue": l[0] || (l[0] = (e) => o(p).paymentDate = e), type: "date", "value-format": "x", placeholder: "选择申请日期", disabledDate: (e) => e.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "220px" } }, null, 8, ["modelValue", "disabledDate"])]), _: 1 }), a(m, { label: "开户行" }, { default: t(() => [r("span", null, u(s.detailInfo.supplierBankName), 1)]), _: 1 }), a(m, { label: "银行账号" }, { default: t(() => [r("span", null, u(s.detailInfo.supplierBankAccount), 1)]), _: 1 }), a(m, { label: "备注", prop: "remark" }, { default: t(() => [a(L, { modelValue: o(p).remark, "onUpdate:modelValue": l[1] || (l[1] = (e) => o(p).remark = e), type: "textarea", style: { width: "100%" }, maxlength: "200", "show-word-limit": "", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请输入备注" }, null, 8, ["modelValue"])]), _: 1 }), a(m, { label: "附件" }, { default: t(() => [a(o(ce), { ref: "uploadRef", files: o(p).attachments, "onUpdate:files": l[2] || (l[2] = (e) => o(p).attachments = e), "file-classify": o(pe).CONTRACT_ATT.V, limit: 1, accept: ".jpg,.png,.pdf,.jpeg" }, null, 8, ["files", "file-classify"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, Ae = ie(he, [["__scopeId", "data-v-43ff1cc6"]]);
export {
  Ae as default
};
