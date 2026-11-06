import { ref as V } from "vue";
import { watch as G } from "vue";
import { nextTick as Ve } from "vue";
import { computed as O } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as a } from "vue";
import { createBlock as d } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as c } from "vue";
import { unref as i } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as k } from "vue";
import { createElementBlock as s } from "vue";
import { Fragment as _ } from "vue";
import { createVNode as p } from "vue";
import { isRef as ge } from "vue";
import { ElMessage as Y } from "element-plus";
import { ElFormItem as Ue } from "element-plus";
import { ElInput as be } from "element-plus";
import { ElDatePicker as Ae } from "element-plus";
import { ElDivider as _e } from "element-plus";
import { ElTableColumn as Ne } from "element-plus";
import { ElInputNumber as De } from "element-plus";
import { ElForm as Se } from "element-plus";
import { ElNotification as Te } from "element-plus";
import { e as W, a as Ce } from "../../../../../modules/reimbursement-d297ed56.js";
import { b as Ee } from "../../../../../modules/collection-9275714a.js";
import { _ as Be, t as Le, u as Pe, bN as Re, ia as H, jC as h, bb as Me, bV as K, cy as Q, p as $e, bD as T, aw as ze, bC as je, i as qe } from "../../../../../shared/runtime.js";
import Je from "./expense.vue.js";
import "../../../../../modules/expense-config-93f15b94.js";
const Fe = { class: "dialog-title" }, Ge = { style: { position: "absolute", right: "20px" } }, Oe = { class: "form-row", style: { display: "flex" } }, Ye = { style: { width: "360px" } }, We = { key: 1 }, He = { style: { width: "460px" } }, Ke = { key: 1 }, Qe = { key: 2, style: { "margin-left": "5px" } }, Xe = { class: "form-row", style: { display: "flex" } }, Ze = { style: { width: "360px" } }, et = { style: { width: "360px" } }, tt = { key: 1 }, lt = { class: "form-row", style: { display: "flex" } }, at = { style: { width: "360px" } }, nt = { key: 1 }, ot = { style: { width: "360px" } }, it = { key: 1 }, ut = { class: "form-row", style: { display: "flex" } }, dt = { style: { width: "360px" } }, st = { key: 1 }, ct = { style: { width: "360px" } }, rt = { key: 1 }, pt = { key: 0, class: "form-row", style: { display: "flex" } }, mt = { style: { width: "360px" } }, yt = { key: 1 }, ft = { style: { width: "360px" } }, vt = { key: 1 }, ht = { class: "form-row", style: { display: "flex" } }, kt = { style: { width: "360px" } }, xt = { key: 1 }, wt = { style: { width: "360px" } }, It = { key: 0, style: { "margin-left": "5px" } }, Vt = { style: { width: "360px" } }, gt = { key: 1 }, Ut = { key: 1 }, bt = { key: 1 }, At = { key: 1 }, _t = { key: 1 }, Nt = { key: 1 }, Dt = { key: 0 }, St = { key: 1 }, Tt = { key: 1 }, Ct = { class: "add-row-box" }, Et = { __name: "detail", props: { collectionInfo: { type: Object, default: () => {
} }, modelValue: { type: Boolean, require: true }, type: { type: String, require: true } }, emits: ["success", "update:modelValue"], setup(u, { emit: X }) {
  const { decimalPrecision: g } = Le(), b = V(), Z = { id: void 0, applyAmount: void 0, applyDate: void 0, applyDepartId: void 0, applyUserId: void 0, collectionBankAccount: void 0, collectionDepositBank: void 0, collectionUserId: void 0, detailList: [], projectId: void 0, remark: void 0 }, N = u, ee = { key: "companyId", label: "companyName", value: "companyId" }, e = V(JSON.parse(JSON.stringify(Z))), U = V({}), v = V(false), P = X, { visible: C, handleClose: te } = Pe({ emit: P, props: N }), R = V(), M = V();
  G(() => e.value.projectId, (n) => {
    n ? de(n) : U.value = {};
  }, { deep: true, immediate: true }), G(() => N.collectionInfo.id, (n) => {
    n && ue();
  }, { deep: true, immediate: true });
  const le = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], applyAmount: [{ required: true, message: "请输入申请金额", trigger: "blur" }], collectionUserId: [{ required: true, message: "请选择收款人", trigger: "change" }], applyUserId: [{ required: true, message: "请选择申请人", trigger: "change" }], applyDate: [{ required: true, message: "请选择申请日期", trigger: "change" }], paymentUnitId: [{ required: true, message: "请选择付款单位", trigger: "change" }] }, ae = { choseId: [{ required: true, message: "请选择报销种类", trigger: "change" }], applyAmount: [{ required: true, message: "请输入申请金额", trigger: "change", type: "number" }] }, { tableValidate: ne, wrongCellMask: oe } = ze({ rules: ae }), $ = V(), A = V([]);
  function ie() {
    v.value = true, je(b, e);
  }
  function E() {
    v.value = false, te();
  }
  function ue() {
    const n = JSON.parse(JSON.stringify(N.collectionInfo));
    e.value = n, b.value && Ve(() => {
      b.value.clearValidate();
    });
  }
  async function de(n) {
    let l = {};
    try {
      l = await Ee({ projectId: n }), console.log(l);
    } catch (m) {
      console.log("获取合同信息", m);
    } finally {
      U.value = l, $.value = U.value.businessType ? Re.VL[U.value.businessType] : "";
    }
  }
  function se(n) {
    if (n) {
      const l = U.value.companyBankAccountList.find((m) => m.companyId === n);
      e.value.paymentBankAccount = l.account, e.value.paymentDepositBank = l.depositBank, e.value.paymentUnit = l.companyName;
    } else e.value.paymentBankAccount = "", e.value.paymentDepositBank = "", e.value.paymentUnit = "";
  }
  function ce() {
    const n = R.value.getNodeInfo();
    qe(n) ? e.value.collectionUserName = n.label : e.value.collectionUserName = void 0;
  }
  function re() {
    if (e.value.applyUserId) {
      const n = M.value.getNodeInfo();
      e.value.applyDepartId = n.parentDeptId, e.value.applyDepartName = n.parentDeptName, e.value.applyUserName = n.label, e.value.collectionUserId || (e.value.collectionUserId = e.value.applyUserId);
    } else e.value.applyDepartId = void 0, e.value.applyDepartName = void 0, e.value.applyUserName = void 0;
  }
  function z(n, l) {
    if (n && (e.value.detailList[l].invoiceAmount = n), e.value.detailList.length > 0) {
      let m = 0;
      e.value.detailList.forEach((y) => {
        y.applyAmount > 0 && (m += y.applyAmount);
      }), e.value.applyAmount = m;
    } else e.value.applyAmount = void 0;
  }
  function pe() {
    if (e.value.detailList.length > 0) {
      let n = 0;
      e.value.detailList.forEach((l) => {
        l.actuallyPayAmount > 0 && (n += l.actuallyPayAmount);
      }), e.value.actuallyPayAmount = n;
    } else e.value.actuallyPayAmount = void 0;
  }
  const j = O(() => e.value.applyAmount ? H(e.value.applyAmount) : ""), q = O(() => e.value.actuallyPayAmount ? H(e.value.actuallyPayAmount) : "");
  function me(n) {
    n && (n.type === 1 ? (e.value.detailList[n.dataIndex].expenseTypeId = n.id, e.value.detailList[n.dataIndex].dictionaryId = void 0) : (e.value.detailList[n.dataIndex].expenseTypeId = n.parentId, e.value.detailList[n.dataIndex].dictionaryId = n.id));
  }
  function J(n) {
    e.value.detailList[n].taxRate && e.value.detailList[n].invoiceAmount ? e.value.detailList[n].inputTax = (e.value.detailList[n].invoiceAmount * e.value.detailList[n].taxRate / 100).toFixed(g.value.contract) : e.value.detailList[n].inputTax = void 0;
  }
  function ye(n) {
    e.value.detailList.splice(n, 1), z();
  }
  function fe() {
    e.value.detailList.push({ applyAmount: void 0, choseId: void 0, dictionaryId: void 0, expenseTypeId: void 0, inputTax: void 0, invoiceAmount: void 0, invoiceNo: void 0, invoiceType: void 0, taxRate: void 0, dataIndex: e.value.detailList.length });
  }
  function ve(n, l) {
    if (n.invoiceNo) {
      const m = A.value.find((y) => y.index === l);
      A.value.findIndex((y) => y.invoiceNo === n.invoiceNo) > -1 ? (Y({ message: "发票号已存在，请重新填写", type: "error" }), n.invoiceNo = void 0, m && (m.invoiceNo = void 0)) : m ? m.invoiceNo = n.invoiceNo : A.value.push({ invoiceNo: n.invoiceNo, index: l });
    }
  }
  function B() {
    Te({ title: "提交成功", type: "success" }), P("success"), E();
  }
  async function L(n) {
    try {
      if (n === h.ENUM.REJECT.V) {
        const l = { confirmStatus: n, id: e.value.id };
        await W(l), B();
      } else {
        if (e.value.detailList.length <= 0) return Y({ message: "请先填写报销明细", type: "error" }), false;
        const { validResult: l, dealList: m } = ne(e.value.detailList);
        if (l) e.value.detailList = m;
        else return l;
        if (await b.value.validate(), N.type === "detail") await Ce(e.value), A.value = [], B();
        else {
          const y = { actuallyPayAmount: e.value.actuallyPayAmount, confirmStatus: n, detailConfirmDTOParamList: e.value.detailList, id: e.value.id, paymentBankAccount: e.value.paymentBankAccount, paymentDepositBank: e.value.paymentDepositBank, paymentUnit: e.value.paymentUnit, paymentUnitId: e.value.paymentUnitId };
          await W(y), A.value = [], B();
        }
      }
    } catch (l) {
      console.log("报销修改", l);
    }
  }
  return (n, l) => {
    const m = S("common-button"), y = Ue, I = be, he = Ae, F = S("common-select"), ke = _e, x = Ne, D = De, xe = S("common-table"), we = Se, Ie = S("common-drawer");
    return a(), d(Ie, { "append-to-body": "", modelValue: i(C), "onUpdate:modelValue": l[15] || (l[15] = (t) => ge(C) ? C.value = t : null), top: "10vh", width: "600px", "before-close": E, title: "报销信息", "wrapper-closable": false, size: "1300px" }, { title: o(() => [c("div", Fe, [l[21] || (l[21] = c("span", { style: { "margin-right": "5px" } }, "报销信息", -1)), u.collectionInfo.confirmStatus ? (a(), d(m, { key: 0, size: "default", type: u.collectionInfo.confirmStatus == i(h).ENUM.REJECT.V ? "info" : u.collectionInfo.confirmStatus == i(h).ENUM.PASS.V ? "success" : "warning" }, { default: o(() => [w(r(u.collectionInfo.confirmStatus == i(h).ENUM.REJECT.V ? "已退回" : u.collectionInfo.confirmStatus == i(h).ENUM.PASS.V ? "已确认" : "确认中"), 1)]), _: 1 }, 8, ["type"])) : k("", true), c("span", Ge, [u.collectionInfo.confirmStatus ? (a(), s(_, { key: 0 }, [v.value ? (a(), d(m, { key: 1, type: "primary", size: "default", onClick: L }, { default: o(() => l[19] || (l[19] = [w("提交")])), _: 1, __: [19] })) : (a(), s(_, { key: 0 }, [u.collectionInfo.confirmStatus == i(h).ENUM.AUDITING.V && u.type === "audit" ? (a(), d(m, { key: 0, size: "default", type: "info", onClick: l[0] || (l[0] = (t) => L(i(h).ENUM.REJECT.V)) }, { default: o(() => l[16] || (l[16] = [w("退回")])), _: 1, __: [16] })) : k("", true), u.collectionInfo.confirmStatus == i(h).ENUM.AUDITING.V && u.type === "audit" ? (a(), d(m, { key: 1, size: "default", type: "success", onClick: l[1] || (l[1] = (t) => L(i(h).ENUM.PASS.V)) }, { default: o(() => l[17] || (l[17] = [w("确定")])), _: 1, __: [17] })) : k("", true), u.collectionInfo.confirmStatus == i(h).ENUM.REJECT.V && u.type === "detail" ? (a(), d(m, { key: 2, size: "default", type: "primary", onClick: ie }, { default: o(() => l[18] || (l[18] = [w("重新编辑")])), _: 1, __: [18] })) : k("", true)], 64))], 64)) : k("", true), p(m, { size: "default", onClick: E }, { default: o(() => l[20] || (l[20] = [w("关闭")])), _: 1, __: [20] })])])]), content: o(() => [p(we, { ref_key: "formRef", ref: b, model: e.value, rules: le, size: "default", "label-width": "140px" }, { default: o(() => [c("div", Oe, [p(y, { label: "项目", prop: "projectId" }, { default: o(() => [c("div", Ye, [v.value ? (a(), d(i(Me), { key: 0, modelValue: e.value.projectId, "onUpdate:modelValue": l[2] || (l[2] = (t) => e.value.projectId = t), style: { width: "320px" }, class: "filter-item" }, null, 8, ["modelValue"])) : (a(), s("span", We, r(u.collectionInfo.projectName), 1))])]), _: 1 }), p(y, { label: "申请金额(元)", prop: "applyAmount" }, { default: o(() => [c("div", He, [v.value ? (a(), d(I, { key: 0, modelValue: e.value.applyAmount, "onUpdate:modelValue": l[3] || (l[3] = (t) => e.value.applyAmount = t), type: "text", placeholder: "申请金额", style: { width: "320px" }, disabled: "" }, null, 8, ["modelValue"])) : (a(), s("div", Ke, r(u.collectionInfo.applyAmount ? i(K)(u.collectionInfo.applyAmount, i(g).contract) : ""), 1)), j.value ? (a(), s("div", Qe, r(`${j.value}`), 1)) : k("", true)])]), _: 1 })]), c("div", Xe, [p(y, { label: "业务类型", prop: "businessType" }, { default: o(() => [c("div", Ze, [c("span", null, r($.value), 1)])]), _: 1 }), p(y, { label: "申请人", prop: "applyUserId" }, { default: o(() => [c("div", et, [v.value ? (a(), d(Q, { key: 0, ref_key: "applyRef", ref: M, modelValue: e.value.applyUserId, "onUpdate:modelValue": l[4] || (l[4] = (t) => e.value.applyUserId = t), filterable: "", clearable: "", "show-all-levels": "", style: { width: "320px" }, placeholder: "申请人", onChange: re }, null, 8, ["modelValue"])) : (a(), s("span", tt, r(u.collectionInfo.applyUserName), 1))])]), _: 1 })]), c("div", lt, [p(y, { label: "收款人", prop: "collectionUserId" }, { default: o(() => [c("div", at, [v.value ? (a(), d(Q, { key: 0, modelValue: e.value.collectionUserId, "onUpdate:modelValue": l[5] || (l[5] = (t) => e.value.collectionUserId = t), ref_key: "collectionRef", ref: R, filterable: "", clearable: "", "show-all-levels": "", style: { width: "320px" }, placeholder: "收款人", onChange: ce }, null, 8, ["modelValue"])) : (a(), s("span", nt, r(e.value.collectionUserName), 1))])]), _: 1 }), p(y, { label: "申请日期", prop: "applyDate" }, { default: o(() => [c("div", ot, [v.value ? (a(), d(he, { key: 0, modelValue: e.value.applyDate, "onUpdate:modelValue": l[6] || (l[6] = (t) => e.value.applyDate = t), type: "date", "value-format": "x", placeholder: "申请日期", style: { width: "320px" }, disabledDate: (t) => t.getTime() > (/* @__PURE__ */ new Date()).getTime() }, null, 8, ["modelValue", "disabledDate"])) : (a(), s("span", it, r(u.collectionInfo.applyDate ? i($e)(u.collectionInfo.applyDate, "{y}-{m}-{d}") : "-"), 1))])]), _: 1 })]), c("div", ut, [p(y, { label: "收款开户行", prop: "collectionDepositBank" }, { default: o(() => [c("div", dt, [v.value ? (a(), d(I, { key: 0, modelValue: e.value.collectionDepositBank, "onUpdate:modelValue": l[7] || (l[7] = (t) => e.value.collectionDepositBank = t), type: "text", placeholder: "收款开户行", style: { width: "320px" }, maxlength: "50" }, null, 8, ["modelValue"])) : (a(), s("span", st, r(e.value.collectionDepositBank), 1))])]), _: 1 }), p(y, { label: "收款账号", prop: "collectionBankAccount" }, { default: o(() => [c("div", ct, [v.value ? (a(), d(I, { key: 0, modelValue: e.value.collectionBankAccount, "onUpdate:modelValue": l[8] || (l[8] = (t) => e.value.collectionBankAccount = t), type: "text", placeholder: "收款账号", style: { width: "320px" }, maxlength: "30" }, null, 8, ["modelValue"])) : (a(), s("span", rt, r(e.value.collectionBankAccount), 1))])]), _: 1 })]), u.collectionInfo.confirmStatus == i(h).PASS.V ? (a(), s("div", pt, [p(y, { label: "付款单位", prop: "paymentUnitId" }, { default: o(() => [c("div", mt, [u.collectionInfo.confirmStatus == i(h).ENUM.AUDITING.V && u.type === "audit" ? (a(), d(F, { key: 0, modelValue: e.value.paymentUnitId, "onUpdate:modelValue": l[9] || (l[9] = (t) => e.value.paymentUnitId = t), options: U.value.companyBankAccountList, type: "other", dataStructure: ee, size: "default", clearable: "", class: "filter-item", placeholder: "付款单位", style: { width: "320px" }, onChange: se }, null, 8, ["modelValue", "options"])) : (a(), s("span", yt, r(e.value.paymentUnit), 1))])]), _: 1 }), u.collectionInfo.confirmStatus == i(h).PASS.V ? (a(), d(y, { key: 0, label: "付款开户行", prop: "paymentDepositBank" }, { default: o(() => [c("div", ft, [u.collectionInfo.confirmStatus == i(h).ENUM.AUDITING.V && u.type === "audit" ? (a(), d(I, { key: 0, modelValue: e.value.paymentDepositBank, "onUpdate:modelValue": l[10] || (l[10] = (t) => e.value.paymentDepositBank = t), type: "text", placeholder: "付款开户行", style: { width: "320px" } }, null, 8, ["modelValue"])) : (a(), s("span", vt, r(e.value.paymentDepositBank), 1))])]), _: 1 })) : k("", true)])) : k("", true), c("div", ht, [u.collectionInfo.confirmStatus == i(h).PASS.V ? (a(), d(y, { key: 0, label: "付款账号", prop: "paymentBankAccount" }, { default: o(() => [c("div", kt, [u.collectionInfo.confirmStatus == i(h).ENUM.AUDITING.V && u.type === "audit" ? (a(), d(I, { key: 0, modelValue: e.value.paymentBankAccount, "onUpdate:modelValue": l[11] || (l[11] = (t) => e.value.paymentBankAccount = t), type: "text", placeholder: "付款账号", style: { width: "320px" } }, null, 8, ["modelValue"])) : (a(), s("span", xt, r(e.value.paymentBankAccount), 1))])]), _: 1 })) : k("", true), u.collectionInfo.confirmStatus == i(h).PASS.V ? (a(), d(y, { key: 1, label: "实付金额(元)", prop: "actuallyPayAmount" }, { default: o(() => [c("div", wt, [c("span", null, r(e.value.actuallyPayAmount ? i(K)(e.value.actuallyPayAmount, i(g).contract) : ""), 1), q.value ? (a(), s("span", It, r(`大写:${q.value}`), 1)) : k("", true)])]), _: 1 })) : k("", true)]), p(y, { label: "备注", prop: "remark" }, { default: o(() => [c("div", Vt, [v.value ? (a(), d(I, { key: 0, modelValue: e.value.remark, "onUpdate:modelValue": l[12] || (l[12] = (t) => e.value.remark = t), type: "textarea", autosize: { minRows: 6, maxRows: 8 }, maxlength: 200, "show-word-limit": "", placeholder: "可填写备注", style: { "max-width": "500px" } }, null, 8, ["modelValue"])) : (a(), s("span", gt, r(u.collectionInfo.remark), 1))])]), _: 1 }), p(ke, null, { default: o(() => l[22] || (l[22] = [c("span", { class: "title" }, "报销明细", -1)])), _: 1, __: [22] }), p(xe, { ref: "detailRef", border: "", data: e.value.detailList, "max-height": 300, style: { width: "100%" }, class: "table-form", "cell-class-name": i(oe) }, { default: o(() => [p(x, { label: "序号", type: "index", align: "center", width: "55" }), p(x, { prop: "choseId", label: "报销种类", align: "center", "min-width": "250" }, { default: o((t) => [v.value ? (a(), d(i(Je), { key: t.$index, modelValue: t.row.choseId, "onUpdate:modelValue": (f) => t.row.choseId = f, onChange: me, "data-index": t.$index }, null, 8, ["modelValue", "onUpdate:modelValue", "data-index"])) : (a(), s("span", Ut, r(t.row.expenseTypeName && t.row.dictionaryLabel ? t.row.expenseTypeName + "/" + t.row.dictionaryLabel : t.row.expenseTypeName), 1))]), _: 1 }), p(x, { prop: "applyAmount", label: "申请金额（元）", align: "center", "min-width": "120" }, { default: o((t) => [v.value ? (a(), d(D, { key: 0, modelValue: t.row.applyAmount, "onUpdate:modelValue": (f) => t.row.applyAmount = f, min: 1, max: 99999999999, step: 100, precision: i(g).contract, size: "default", "controls-position": "right", placeholder: "申请金额", style: { width: "100%", "max-width": "200px" }, onChange: (f) => z(t.row.applyAmount, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (a(), s("span", bt, r(t.row.applyAmount), 1))]), _: 1 }), p(x, { prop: "invoiceType", label: "发票类型", align: "center", "min-width": "160" }, { default: o((t) => [v.value ? (a(), d(F, { key: 0, modelValue: t.row.invoiceType, "onUpdate:modelValue": (f) => t.row.invoiceType = f, options: i(T).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "发票类型", style: { width: "130px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (a(), s("span", At, r(t.row.invoiceType ? i(T).VL[t.row.invoiceType] : ""), 1))]), _: 1 }), p(x, { prop: "invoiceNo", label: "发票号码", align: "center", "min-width": "150" }, { default: o((t) => [v.value ? (a(), d(I, { key: 0, modelValue: t.row.invoiceNo, "onUpdate:modelValue": (f) => t.row.invoiceNo = f, type: "text", placeholder: "发票号码", style: { width: "100%" }, onBlur: (f) => ve(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])) : (a(), s("span", _t, r(t.row.invoiceNo), 1))]), _: 1 }), p(x, { prop: "invoiceAmount", label: "发票面额（元）", align: "center", "min-width": "120" }, { default: o((t) => [v.value ? (a(), d(D, { key: 0, modelValue: t.row.invoiceAmount, "onUpdate:modelValue": (f) => t.row.invoiceAmount = f, min: t.row.applyAmount ? t.row.applyAmount : 1, max: 99999999999, step: 100, precision: i(g).contract, size: "default", "controls-position": "right", placeholder: "发票面额", style: { width: "100%", "max-width": "200px" }, onChange: (f) => J(t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "precision", "onChange"])) : (a(), s("span", Nt, r(t.row.invoiceAmount), 1))]), _: 1 }), p(x, { prop: "taxRate", label: "税率", align: "center", "min-width": "80" }, { default: o((t) => [t.row.invoiceType === i(T).ENUM.SPECIAL.V ? (a(), s("div", Dt, [v.value ? (a(), s(_, { key: 0 }, [p(D, { modelValue: t.row.taxRate, "onUpdate:modelValue": (f) => t.row.taxRate = f, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "60px", "text-align": "center" }, placeholder: "0-100", onChange: (f) => J(t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"]), l[23] || (l[23] = w("% "))], 64)) : (a(), s("span", St, r(t.row.taxRate ? t.row.taxRate + "%" : ""), 1))])) : k("", true)]), _: 1 }), p(x, { prop: "inputTax", label: "进项税额(元)", align: "center", "min-width": "130" }, { default: o((t) => [v.value ? (a(), s(_, { key: 0 }, [t.row.invoiceType === i(T).ENUM.SPECIAL.V ? (a(), d(I, { key: 0, modelValue: t.row.inputTax, "onUpdate:modelValue": (f) => t.row.inputTax = f, type: "text", placeholder: "先输入税率", style: { width: "100px" }, disabled: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : k("", true)], 64)) : (a(), s(_, { key: 1 }, [w(r(t.row.inputTax), 1)], 64))]), _: 1 }), u.collectionInfo.confirmStatus == i(h).PASS.V ? (a(), d(x, { key: 0, prop: "actuallyPayAmount", label: "实付金额(元)", align: "center", "min-width": "160" }, { default: o((t) => [u.collectionInfo.confirmStatus == i(h).ENUM.AUDITING.V && u.type === "audit" ? (a(), d(D, { key: 0, modelValue: t.row.actuallyPayAmount, "onUpdate:modelValue": (f) => t.row.actuallyPayAmount = f, min: 1, max: 99999999999, step: 100, precision: i(g).contract, size: "default", "controls-position": "right", placeholder: "实付金额", style: { width: "100%", "max-width": "200px" }, onChange: l[13] || (l[13] = (f) => pe()) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (a(), s("span", Tt, r(t.row.actuallyPayAmount), 1))]), _: 1 })) : k("", true), v.value ? (a(), d(x, { key: 1, label: "操作", align: "center" }, { default: o((t) => [p(m, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (f) => ye(t.$index) }, null, 8, ["onClick"])]), _: 1 })) : k("", true)]), _: 1 }, 8, ["data", "cell-class-name"]), c("div", Ct, [v.value ? (a(), d(m, { key: 0, size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: l[14] || (l[14] = (t) => fe()) }, { default: o(() => l[24] || (l[24] = [w("继续添加")])), _: 1, __: [24] })) : k("", true)])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"]);
  };
} }, zt = Be(Et, [["__scopeId", "data-v-6ae0cd22"]]);
export {
  zt as default
};
