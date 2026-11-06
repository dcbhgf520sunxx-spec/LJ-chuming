import { ref as b } from "vue";
import { watch as J } from "vue";
import { nextTick as we } from "vue";
import { computed as F } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createBlock as i } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as p } from "vue";
import { unref as u } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as h } from "vue";
import { createElementBlock as s } from "vue";
import { Fragment as U } from "vue";
import { createVNode as m } from "vue";
import { isRef as ke } from "vue";
import { ElFormItem as xe } from "element-plus";
import { ElInput as ge } from "element-plus";
import { ElDatePicker as Ve } from "element-plus";
import { ElDivider as Ie } from "element-plus";
import { ElTableColumn as _e } from "element-plus";
import { ElInputNumber as be } from "element-plus";
import { ElForm as Ue } from "element-plus";
import { ElNotification as Ae } from "element-plus";
import { b as Ne } from "../../../../../modules/collection-9275714a.js";
import { e as G, a as Ce } from "../../../../../modules/reimbursement-d297ed56.js";
import { _ as De, t as Te, u as Ee, ia as O, jC as w, bb as Be, bV as Y, bN as Se, cy as W, p as Le, bD as D, aw as Pe, bC as Re, i as Me } from "../../../../../shared/runtime.js";
import ze from "./expense.vue.js";
import "../../../../../modules/expense-config-93f15b94.js";
const $e = { class: "dialog-title" }, je = { style: { position: "absolute", right: "20px" } }, qe = { class: "form-row", style: { display: "flex" } }, Je = { style: { width: "360px" } }, Fe = { key: 1 }, Ge = { style: { width: "460px" } }, Oe = { key: 1 }, Ye = { key: 2, style: { "margin-left": "5px" } }, We = { class: "form-row", style: { display: "flex" } }, He = { style: { width: "360px" } }, Ke = { style: { width: "360px" } }, Qe = { key: 1 }, Xe = { class: "form-row", style: { display: "flex" } }, Ze = { style: { width: "360px" } }, et = { key: 1 }, tt = { style: { width: "360px" } }, lt = { key: 1 }, at = { class: "form-row", style: { display: "flex" } }, nt = { style: { width: "360px" } }, ot = { key: 1 }, it = { style: { width: "360px" } }, ut = { key: 1 }, dt = { key: 0, class: "form-row", style: { display: "flex" } }, st = { style: { width: "360px" } }, rt = { key: 1 }, pt = { style: { width: "360px" } }, ct = { key: 1 }, mt = { class: "form-row", style: { display: "flex" } }, yt = { style: { width: "360px" } }, ft = { key: 1 }, vt = { style: { width: "360px" } }, ht = { key: 0, style: { "margin-left": "5px" } }, wt = { style: { width: "360px" } }, kt = { key: 1 }, xt = { key: 1 }, gt = { key: 1 }, Vt = { key: 1 }, It = { key: 1 }, _t = { key: 1 }, bt = { key: 0 }, Ut = { key: 1 }, At = { key: 1 }, Nt = { class: "add-row-box" }, Ct = { __name: "detail-confirm", props: { collectionInfo: { type: Object, default: () => {
} }, modelValue: { type: Boolean, require: true }, type: { type: String, require: true } }, emits: ["success", "update:modelValue"], setup(d, { emit: H }) {
  const { decimalPrecision: I } = Te(), V = b(), K = { id: void 0, applyAmount: void 0, applyDate: void 0, applyDepartId: void 0, applyUserId: void 0, collectionBankAccount: void 0, collectionDepositBank: void 0, collectionUserId: void 0, detailList: [], projectId: void 0, remark: void 0 }, A = d, Q = { key: "companyId", label: "companyName", value: "companyId" }, e = b(JSON.parse(JSON.stringify(K))), _ = b({}), r = b(false), L = H, { visible: T, handleClose: X } = Ee({ emit: L, props: A }), P = b(), R = b();
  J(() => e.value.projectId, (n) => {
    n ? oe(n) : _.value = {};
  }, { deep: true, immediate: true }), J(() => A.collectionInfo.id, (n) => {
    n && ne();
  }, { deep: true, immediate: true });
  const Z = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], applyAmount: [{ required: true, message: "请输入申请金额", trigger: "blur" }], collectionUserId: [{ required: true, message: "请选择收款人", trigger: "change" }], applyUserId: [{ required: true, message: "请选择申请人", trigger: "change" }], applyDate: [{ required: true, message: "请选择申请日期", trigger: "change" }], paymentUnitId: [{ required: true, message: "请选择付款单位", trigger: "change" }] }, ee = { choseId: [{ required: true, message: "请选择报销种类", trigger: "change" }], applyAmount: [{ required: true, message: "请输入申请金额", trigger: "change", type: "number" }], actuallyPayAmount: [{ required: true, message: "请输入实付金额", trigger: "change", type: "number" }] }, { tableValidate: te, wrongCellMask: le } = Pe({ rules: ee });
  function ae() {
    r.value = true, Re(V, e);
  }
  function E() {
    r.value = false, X();
  }
  function ne() {
    V.value && V.value.resetFields();
    const n = JSON.parse(JSON.stringify(A.collectionInfo));
    e.value = n, V.value && we(() => {
      V.value.clearValidate();
    });
  }
  async function oe(n) {
    let l = {};
    try {
      l = await Ne({ projectId: n });
    } catch (v) {
      console.log("获取合同信息", v);
    } finally {
      _.value = l;
    }
  }
  function ie(n) {
    if (n) {
      const l = _.value.companyBankAccountList.find((v) => v.companyId === n);
      e.value.paymentBankAccount = l.account, e.value.paymentDepositBank = l.depositBank, e.value.paymentUnit = l.companyName;
    } else e.value.paymentBankAccount = "", e.value.paymentDepositBank = "", e.value.paymentUnit = "";
  }
  function ue() {
    const n = P.value.getNodeInfo();
    Me(n) ? e.value.collectionUserName = n.label : e.value.collectionUserName = void 0;
  }
  function de() {
    if (e.value.applyUserId) {
      const n = R.value.getNodeInfo();
      e.value.applyDepartId = n.parentDeptId, e.value.applyDepartName = n.parentDeptName, e.value.applyUserName = n.label, e.value.collectionUserId || (e.value.collectionUserId = e.value.applyUserId);
    } else e.value.applyDepartId = void 0, e.value.applyDepartName = void 0, e.value.applyUserName = void 0;
  }
  function M(n, l) {
    if (n && (e.value.detailList[l].invoiceAmount = n), e.value.detailList.length > 0) {
      let v = 0;
      e.value.detailList.forEach((f) => {
        f.applyAmount > 0 && (v += f.applyAmount);
      }), e.value.applyAmount = v;
    } else e.value.applyAmount = void 0;
  }
  function se() {
    if (e.value.detailList.length > 0) {
      let n = 0;
      e.value.detailList.forEach((l) => {
        l.actuallyPayAmount > 0 && (n += l.actuallyPayAmount);
      }), e.value.actuallyPayAmount = n;
    } else e.value.actuallyPayAmount = void 0;
  }
  const z = F(() => e.value.applyAmount ? O(e.value.applyAmount) : ""), $ = F(() => e.value.actuallyPayAmount ? O(e.value.actuallyPayAmount) : "");
  function re(n) {
    n && (n.type === 1 ? (e.value.detailList[n.dataIndex].expenseTypeId = n.id, e.value.detailList[n.dataIndex].dictionaryId = void 0) : (e.value.detailList[n.dataIndex].expenseTypeId = n.parentId, e.value.detailList[n.dataIndex].dictionaryId = n.id));
  }
  function j(n) {
    e.value.detailList[n].taxRate && e.value.detailList[n].invoiceAmount ? e.value.detailList[n].inputTax = (e.value.detailList[n].invoiceAmount * e.value.detailList[n].taxRate / 100).toFixed(I.value.contract) : e.value.detailList[n].inputTax = void 0;
  }
  function pe(n) {
    e.value.detailList.splice(n, 1), M();
  }
  function ce() {
    e.value.detailList.push({ applyAmount: void 0, choseId: void 0, dictionaryId: void 0, expenseTypeId: void 0, inputTax: void 0, invoiceAmount: void 0, invoiceNo: void 0, invoiceType: void 0, taxRate: void 0, verify: {} });
  }
  function B() {
    Ae({ title: "提交成功", type: "success" }), L("success"), E();
  }
  async function S(n) {
    try {
      if (n === w.ENUM.REJECT.V) {
        const l = { confirmStatus: n, id: e.value.id };
        await G(l), B();
      } else {
        const { validResult: l, dealList: v } = te(e.value.detailList);
        if (l) e.value.detailList = v;
        else return l;
        if (await V.value.validate(), A.type === "detail") await Ce(e.value), B();
        else {
          const f = { actuallyPayAmount: e.value.actuallyPayAmount, confirmStatus: n, detailConfirmDTOParamList: e.value.detailList, id: e.value.id, paymentBankAccount: e.value.paymentBankAccount, paymentDepositBank: e.value.paymentDepositBank, paymentUnit: e.value.paymentUnit, paymentUnitId: e.value.paymentUnitId };
          await G(f), B();
        }
      }
    } catch (l) {
      console.log("报销审核", l);
    }
  }
  return (n, l) => {
    const v = C("common-button"), f = xe, g = ge, me = Ve, q = C("common-select"), ye = Ie, k = _e, N = be, fe = C("common-table"), ve = Ue, he = C("common-drawer");
    return a(), i(he, { "append-to-body": "", modelValue: u(T), "onUpdate:modelValue": l[15] || (l[15] = (t) => ke(T) ? T.value = t : null), top: "10vh", width: "600px", "before-close": E, title: "报销信息", "wrapper-closable": false, size: "1300px" }, { title: o(() => [p("div", $e, [l[21] || (l[21] = p("span", { style: { "margin-right": "5px" } }, "报销信息", -1)), d.collectionInfo.confirmStatus ? (a(), i(v, { key: 0, size: "default", type: d.collectionInfo.confirmStatus == u(w).ENUM.REJECT.V ? "info" : d.collectionInfo.confirmStatus == u(w).ENUM.PASS.V ? "success" : "warning" }, { default: o(() => [x(c(d.collectionInfo.confirmStatus == u(w).ENUM.REJECT.V ? "已退回" : d.collectionInfo.confirmStatus == u(w).ENUM.PASS.V ? "已确认" : "确认中"), 1)]), _: 1 }, 8, ["type"])) : h("", true), p("span", je, [d.collectionInfo.confirmStatus ? (a(), s(U, { key: 0 }, [r.value ? (a(), i(v, { key: 1, type: "primary", size: "default", onClick: S }, { default: o(() => l[19] || (l[19] = [x("提交")])), _: 1, __: [19] })) : (a(), s(U, { key: 0 }, [d.collectionInfo.confirmStatus == u(w).ENUM.AUDITING.V && d.type === "audit" ? (a(), i(v, { key: 0, size: "default", type: "info", onClick: l[0] || (l[0] = (t) => S(u(w).ENUM.REJECT.V)) }, { default: o(() => l[16] || (l[16] = [x("退回")])), _: 1, __: [16] })) : h("", true), d.collectionInfo.confirmStatus == u(w).ENUM.AUDITING.V && d.type === "audit" ? (a(), i(v, { key: 1, size: "default", type: "success", onClick: l[1] || (l[1] = (t) => S(u(w).ENUM.PASS.V)) }, { default: o(() => l[17] || (l[17] = [x("确定")])), _: 1, __: [17] })) : h("", true), d.collectionInfo.confirmStatus == u(w).ENUM.REJECT.V && d.type === "detail" ? (a(), i(v, { key: 2, size: "default", type: "primary", onClick: ae }, { default: o(() => l[18] || (l[18] = [x("重新编辑")])), _: 1, __: [18] })) : h("", true)], 64))], 64)) : h("", true), m(v, { size: "default", onClick: E }, { default: o(() => l[20] || (l[20] = [x("关闭")])), _: 1, __: [20] })])])]), content: o(() => [m(ve, { ref_key: "formRef", ref: V, model: e.value, rules: Z, size: "default", "label-width": "140px" }, { default: o(() => [p("div", qe, [m(f, { label: "项目", prop: "projectId" }, { default: o(() => [p("div", Je, [r.value ? (a(), i(u(Be), { key: 0, modelValue: e.value.projectId, "onUpdate:modelValue": l[2] || (l[2] = (t) => e.value.projectId = t), style: { width: "320px" }, class: "filter-item" }, null, 8, ["modelValue"])) : (a(), s("span", Fe, c(d.collectionInfo.projectName), 1))])]), _: 1 }), m(f, { label: "申请金额(元)", prop: "applyAmount" }, { default: o(() => [p("div", Ge, [r.value ? (a(), i(g, { key: 0, modelValue: e.value.applyAmount, "onUpdate:modelValue": l[3] || (l[3] = (t) => e.value.applyAmount = t), type: "text", placeholder: "申请金额", style: { width: "320px" }, disabled: "" }, null, 8, ["modelValue"])) : (a(), s("div", Oe, c(d.collectionInfo.applyAmount ? u(Y)(d.collectionInfo.applyAmount, u(I).contract) : "-"), 1)), z.value ? (a(), s("div", Ye, c(`${z.value}`), 1)) : h("", true)])]), _: 1 })]), p("div", We, [m(f, { label: "业务类型", prop: "businessType" }, { default: o(() => [p("div", He, [p("span", null, c(_.value.businessType ? u(Se).VL[_.value.businessType] : ""), 1)])]), _: 1 }), m(f, { label: "申请人", prop: "applyUserId" }, { default: o(() => [p("div", Ke, [r.value ? (a(), i(W, { key: 0, ref_key: "applyRef", ref: R, modelValue: e.value.applyUserId, "onUpdate:modelValue": l[4] || (l[4] = (t) => e.value.applyUserId = t), filterable: "", clearable: "", "show-all-levels": "", style: { width: "320px" }, placeholder: "申请人", onChange: de }, null, 8, ["modelValue"])) : (a(), s("span", Qe, c(d.collectionInfo.applyUserName), 1))])]), _: 1 })]), p("div", Xe, [m(f, { label: "收款人", prop: "collectionUserId" }, { default: o(() => [p("div", Ze, [r.value ? (a(), i(W, { key: 0, modelValue: e.value.collectionUserId, "onUpdate:modelValue": l[5] || (l[5] = (t) => e.value.collectionUserId = t), ref_key: "collectionRef", ref: P, filterable: "", clearable: "", "show-all-levels": "", style: { width: "320px" }, placeholder: "收款人", onChange: ue }, null, 8, ["modelValue"])) : (a(), s("span", et, c(e.value.collectionUserName), 1))])]), _: 1 }), m(f, { label: "申请日期", prop: "applyDate" }, { default: o(() => [p("div", tt, [r.value ? (a(), i(me, { key: 0, modelValue: e.value.applyDate, "onUpdate:modelValue": l[6] || (l[6] = (t) => e.value.applyDate = t), type: "date", "value-format": "x", placeholder: "申请日期", style: { width: "320px" }, disabledDate: (t) => t.getTime() > (/* @__PURE__ */ new Date()).getTime() }, null, 8, ["modelValue", "disabledDate"])) : (a(), s("span", lt, c(d.collectionInfo.applyDate ? u(Le)(d.collectionInfo.applyDate, "{y}-{m}-{d}") : "-"), 1))])]), _: 1 })]), p("div", at, [m(f, { label: "收款开户行", prop: "collectionDepositBank" }, { default: o(() => [p("div", nt, [r.value ? (a(), i(g, { key: 0, modelValue: e.value.collectionDepositBank, "onUpdate:modelValue": l[7] || (l[7] = (t) => e.value.collectionDepositBank = t), modelModifiers: { trim: true }, type: "text", placeholder: "收款开户行", style: { width: "320px" }, maxlength: "50" }, null, 8, ["modelValue"])) : (a(), s("span", ot, c(e.value.collectionDepositBank), 1))])]), _: 1 }), m(f, { label: "收款账号", prop: "collectionBankAccount" }, { default: o(() => [p("div", it, [r.value ? (a(), i(g, { key: 0, modelValue: e.value.collectionBankAccount, "onUpdate:modelValue": l[8] || (l[8] = (t) => e.value.collectionBankAccount = t), modelModifiers: { trim: true }, type: "text", placeholder: "收款账号", style: { width: "320px" }, maxlength: "30" }, null, 8, ["modelValue"])) : (a(), s("span", ut, c(e.value.collectionBankAccount), 1))])]), _: 1 })]), r.value ? h("", true) : (a(), s("div", dt, [m(f, { label: "付款单位", prop: "paymentUnitId" }, { default: o(() => [p("div", st, [d.collectionInfo.confirmStatus == u(w).AUDITING.V && d.type === "audit" ? (a(), i(q, { key: 0, modelValue: e.value.paymentUnitId, "onUpdate:modelValue": l[9] || (l[9] = (t) => e.value.paymentUnitId = t), options: _.value.companyBankAccountList, type: "other", dataStructure: Q, size: "default", clearable: "", class: "filter-item", placeholder: "付款单位", style: { width: "320px" }, onChange: ie }, null, 8, ["modelValue", "options"])) : (a(), s("span", rt, c(e.value.paymentUnit), 1))])]), _: 1 }), r.value ? h("", true) : (a(), i(f, { key: 0, label: "付款开户行", prop: "paymentDepositBank" }, { default: o(() => [p("div", pt, [d.collectionInfo.confirmStatus == u(w).AUDITING.V && d.type === "audit" ? (a(), i(g, { key: 0, modelValue: e.value.paymentDepositBank, "onUpdate:modelValue": l[10] || (l[10] = (t) => e.value.paymentDepositBank = t), modelModifiers: { trim: true }, type: "text", placeholder: "付款开户行", style: { width: "320px" }, maxlength: "50" }, null, 8, ["modelValue"])) : (a(), s("span", ct, c(e.value.paymentDepositBank), 1))])]), _: 1 }))])), p("div", mt, [r.value ? h("", true) : (a(), i(f, { key: 0, label: "付款账号", prop: "paymentBankAccount" }, { default: o(() => [p("div", yt, [d.collectionInfo.confirmStatus == u(w).AUDITING.V && d.type === "audit" ? (a(), i(g, { key: 0, modelValue: e.value.paymentBankAccount, "onUpdate:modelValue": l[11] || (l[11] = (t) => e.value.paymentBankAccount = t), modelModifiers: { trim: true }, type: "text", placeholder: "付款账号", style: { width: "320px" }, maxlength: "30" }, null, 8, ["modelValue"])) : (a(), s("span", ft, c(e.value.paymentBankAccount), 1))])]), _: 1 })), r.value ? h("", true) : (a(), i(f, { key: 1, label: "实付金额(元)", prop: "actuallyPayAmount" }, { default: o(() => [p("div", vt, [p("span", null, c(e.value.actuallyPayAmount ? u(Y)(e.value.actuallyPayAmount, u(I).contract) : "-"), 1), $.value ? (a(), s("span", ht, c(`大写:${$.value}`), 1)) : h("", true)])]), _: 1 }))]), m(f, { label: "备注", prop: "remark" }, { default: o(() => [p("div", wt, [r.value ? (a(), i(g, { key: 0, modelValue: e.value.remark, "onUpdate:modelValue": l[12] || (l[12] = (t) => e.value.remark = t), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 6, maxRows: 8 }, maxlength: 200, "show-word-limit": "", placeholder: "可填写备注", style: { "max-width": "500px" } }, null, 8, ["modelValue"])) : (a(), s("span", kt, c(d.collectionInfo.remark), 1))])]), _: 1 }), m(ye, null, { default: o(() => l[22] || (l[22] = [p("span", { class: "title" }, "报销明细", -1)])), _: 1, __: [22] }), m(fe, { ref: "detailRef", border: "", data: e.value.detailList, "max-height": 300, style: { width: "100%" }, class: "table-form", "cell-class-name": u(le) }, { default: o(() => [m(k, { label: "序号", type: "index", align: "center", width: "55" }), m(k, { prop: "choseId", label: "报销种类", align: "center", "min-width": "250" }, { default: o((t) => [r.value ? (a(), i(u(ze), { key: t.$index, modelValue: t.row.choseId, "onUpdate:modelValue": (y) => t.row.choseId = y, onChange: re, "data-index": t.$index }, null, 8, ["modelValue", "onUpdate:modelValue", "data-index"])) : (a(), s("span", xt, c(t.row.expenseTypeName && t.row.dictionaryLabel ? t.row.expenseTypeName + "/" + t.row.dictionaryLabel : t.row.expenseTypeName), 1))]), _: 1 }), m(k, { prop: "applyAmount", label: "申请金额（元）", align: "center", "min-width": "120" }, { default: o((t) => [r.value ? (a(), i(N, { key: 0, modelValue: t.row.applyAmount, "onUpdate:modelValue": (y) => t.row.applyAmount = y, min: 1, max: 99999999999, step: 100, precision: u(I).contract, size: "default", "controls-position": "right", placeholder: "申请金额", style: { width: "100%", "max-width": "200px" }, onChange: (y) => M(t.row.applyAmount, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (a(), s("span", gt, c(t.row.applyAmount), 1))]), _: 1 }), m(k, { prop: "invoiceType", label: "发票类型", align: "center", "min-width": "160" }, { default: o((t) => [r.value ? (a(), i(q, { key: 0, modelValue: t.row.invoiceType, "onUpdate:modelValue": (y) => t.row.invoiceType = y, options: u(D).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "发票类型", style: { width: "130px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (a(), s("span", Vt, c(t.row.invoiceType ? u(D).VL[t.row.invoiceType] : ""), 1))]), _: 1 }), m(k, { prop: "invoiceNo", label: "发票号码", align: "center", "min-width": "150" }, { default: o((t) => [r.value ? (a(), i(g, { key: 0, modelValue: t.row.invoiceNo, "onUpdate:modelValue": (y) => t.row.invoiceNo = y, type: "text", placeholder: "发票号码", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (a(), s("span", It, c(t.row.invoiceNo), 1))]), _: 1 }), m(k, { prop: "invoiceAmount", label: "发票面额（元）", align: "center", "min-width": "120" }, { default: o((t) => [r.value ? (a(), i(N, { key: 0, modelValue: t.row.invoiceAmount, "onUpdate:modelValue": (y) => t.row.invoiceAmount = y, min: t.row.applyAmount ? t.row.applyAmount : 1, max: 99999999999, step: 100, precision: u(I).contract, size: "default", "controls-position": "right", placeholder: "发票面额", style: { width: "100%", "max-width": "200px" }, onChange: (y) => j(t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "precision", "onChange"])) : (a(), s("span", _t, c(t.row.invoiceAmount), 1))]), _: 1 }), m(k, { prop: "taxRate", label: "税率", align: "center", "min-width": "80" }, { default: o((t) => [t.row.invoiceType === u(D).ENUM.SPECIAL.V ? (a(), s("div", bt, [r.value ? (a(), s(U, { key: 0 }, [m(N, { modelValue: t.row.taxRate, "onUpdate:modelValue": (y) => t.row.taxRate = y, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "60px", "text-align": "center" }, placeholder: "0-100", onChange: (y) => j(t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"]), l[23] || (l[23] = x("% "))], 64)) : (a(), s("span", Ut, c(t.row.taxRate ? t.row.taxRate + "%" : ""), 1))])) : h("", true)]), _: 1 }), m(k, { prop: "inputTax", label: "进项税额(元)", align: "center", "min-width": "130" }, { default: o((t) => [r.value ? (a(), s(U, { key: 0 }, [t.row.invoiceType === u(D).ENUM.SPECIAL.V ? (a(), i(g, { key: 0, modelValue: t.row.inputTax, "onUpdate:modelValue": (y) => t.row.inputTax = y, type: "text", placeholder: "先输入税率", style: { width: "100px" }, disabled: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : h("", true)], 64)) : (a(), s(U, { key: 1 }, [x(c(t.row.inputTax), 1)], 64))]), _: 1 }), r.value ? h("", true) : (a(), i(k, { key: 0, prop: "actuallyPayAmount", label: "实付金额(元)", align: "center", "min-width": "160" }, { default: o((t) => [d.collectionInfo.confirmStatus == u(w).ENUM.AUDITING.V && d.type === "audit" ? (a(), i(N, { key: 0, modelValue: t.row.actuallyPayAmount, "onUpdate:modelValue": (y) => t.row.actuallyPayAmount = y, min: 1, max: t.row.applyAmount, step: 100, precision: u(I).contract, size: "default", "controls-position": "right", placeholder: "实付金额", style: { width: "100%", "max-width": "200px" }, onChange: l[13] || (l[13] = (y) => se()) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : (a(), s("span", At, c(t.row.actuallyPayAmount), 1))]), _: 1 })), r.value ? (a(), i(k, { key: 1, label: "操作", align: "center" }, { default: o((t) => [m(v, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (y) => pe(t.$index) }, null, 8, ["onClick"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "cell-class-name"]), p("div", Nt, [r.value ? (a(), i(v, { key: 0, size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: l[14] || (l[14] = (t) => ce()) }, { default: o(() => l[24] || (l[24] = [x("继续添加")])), _: 1, __: [24] })) : h("", true)])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"]);
  };
} }, Pt = De(Ct, [["__scopeId", "data-v-340668b3"]]);
export {
  Pt as default
};
