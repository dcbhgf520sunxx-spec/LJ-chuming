import { reactive as de } from "vue";
import { ref as b } from "vue";
import { useStore as ue } from "vuex";
import { computed as y } from "vue";
import { inject as ie } from "vue";
import { watch as x } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as l } from "vue";
import { withCtx as t } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as M } from "vue";
import { unref as C } from "vue";
import { createElementVNode as d } from "vue";
import { Fragment as pe } from "vue";
import { renderList as ce } from "vue";
import { createBlock as U } from "vue";
import { createCommentVNode as h } from "vue";
import { ElButton as fe } from "element-plus";
import { ElCol as me } from "element-plus";
import { ElDatePicker as _e } from "element-plus";
import { ElFormItem as ge } from "element-plus";
import { ElRow as be } from "element-plus";
import { ElCascader as ye } from "element-plus";
import { ElOption as ve } from "element-plus";
import { ElSelect as Ie } from "element-plus";
import { ElInput as Ve } from "element-plus";
import { ElUpload as we } from "element-plus";
import { ElForm as Ee } from "element-plus";
import { ElTableColumn as Ce } from "element-plus";
import { ElTag as De } from "element-plus";
import { ElTable as Te } from "element-plus";
import { ElDrawer as Ne } from "element-plus";
import { _ as Oe, ia as xe, e2 as D, dp as j, j1 as Ae, ec as Ue, e6 as he } from "../../../../shared/runtime.js";
import { a as Fe, b as ke, c as Ye, i as Le } from "../../../../modules/grant-managment-2c540b60.js";
import { d as $e, u as Me } from "../../../../modules/upload-file-download-812f558c.js";
const je = (T, c, i) => {
  if (!c) return i(new Error("授信人身份证不能为空"));
  /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(c) ? i() : i(new Error("请输入有效的身份证号码"));
}, Re = (T, c, i) => {
  if (!c) return i(new Error("担保人不能为空"));
  if (/^[\u4e00-\u9fa5]{2,5}$/.test(c)) i();
  else return i(new Error("请输入正确的姓名"));
}, Pe = (T, c, i) => {
  if (c.length) i();
  else return i(new Error("附件不能为空"));
}, Se = { startDate: [{ required: true, message: "创建日期不能为空", trigger: "blur" }], accreditingPartyId: [{ required: true, message: "被授信人不能为空", trigger: ["change", "blur"] }], idNumber: [{ required: true, validator: je, trigger: "blur" }], suretyName: [{ required: true, validator: Re, trigger: ["change", "blur"] }], lineOfCredit: [{ required: true, message: "授信额度不能为空", trigger: ["change", "blur"] }], annualInterest: [{ required: true, message: "年息不能为空", trigger: ["change", "blur"] }], closingDate: [{ required: true, message: "有效截止日期不能为空", trigger: "blur" }], accessoryId: [{ validator: Pe, trigger: ["change", "blur"] }] };
const qe = { class: "grant-container" }, Be = { class: "date-container" }, Ge = { key: 0, class: "date-text" }, ze = { __name: "CreateGrant", emits: ["close"], setup(T, { expose: c, emit: i }) {
  const a = de({ accessoryId: [], startDate: (/* @__PURE__ */ new Date()).getTime() }), V = b([]), R = ue(), P = async () => {
    try {
      const s = await Ae.get(`/api/contract/givingCredit/project/${a.accreditingPartyId}`);
      if (!s || !s.length) return D("warning", '该"被授信人"暂无项目');
      V.value = s;
    } catch (s) {
      console.error("获取内包与合营项目失败", s);
    }
  }, S = Object.assign(Se, { accreditingIdNumber: [{ required: true, validator: (s, e, o) => {
    if (!e) return o(new Error("担保人身份证不能为空"));
    /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(e) ? e === (a == null ? void 0 : a.idNumber) ? o(new Error("担保人与被授信人身份证不能相同")) : o() : o(new Error("请输入有效的身份证号码"));
  }, trigger: ["change", "blur"] }] }), F = y(() => a != null && a.lineOfCredit ? xe(a.lineOfCredit) : ""), w = b(null), _ = b(false), k = b(""), Y = b("创建"), f = b([]), L = ie("projectLeaderList"), q = y(() => f.value.length > 0);
  x(() => a.accreditingPartyId, async (s) => {
    s ? await P() : (a.projectId = null, V.value = []);
  });
  const B = (s) => s < /* @__PURE__ */ new Date(), N = y(() => {
    if (!(!a.annualInterest || !a.lineOfCredit)) {
      if (parseFloat(a.lineOfCredit) < 0 || parseFloat(a.annualInterest) < 0) return D("warning", "请输入正确的数字"), "";
      {
        const e = parseFloat(a.annualInterest) / 100 / 12, o = (e * 100).toFixed(2);
        return `${(parseFloat(a.lineOfCredit) * e).toFixed(2)}/${o}%`;
      }
    }
  });
  function G() {
    const s = (/* @__PURE__ */ new Date()).getFullYear();
    return s % 4 === 0 && s % 100 !== 0 || s % 400 === 0 ? 366 : 365;
  }
  const O = y(() => {
    if (!(!a.annualInterest || !a.lineOfCredit)) {
      if (parseFloat(a.lineOfCredit) < 0 || parseFloat(a.annualInterest) < 0) return "";
      {
        const e = parseFloat(a.annualInterest) / 100 / G(), o = (e * 100).toFixed(2);
        return `${(parseFloat(a.lineOfCredit) * e).toFixed(2)}/${o}%`;
      }
    }
  });
  x([() => N.value, () => O.value], ([s, e], [o, r]) => {
    s && (a.monthlyInterest = s), e && (a.dayInterest = e);
  });
  const z = y(() => {
    if (!a.startDate || !a.closingDate) return;
    const s = Math.abs(a.closingDate - a.startDate);
    return console.log(s), `${Math.ceil(s / (1e3 * 60 * 60 * 24) - 1)}天`;
  }), H = async () => {
    try {
      const s = await Fe(a.id);
      console.log(s), f.value = Ue([s.attachmentDTOS]), f.value.forEach((e) => {
        e.updateTime = e.createTime, e.status = 1;
      }), [s.attachmentDTOS].length && (a.accessoryId = [s.attachmentDTOS].map((e) => e.id)), Object.assign(a, s);
    } catch (s) {
      console.error("获取授信详情失败:", s);
    }
  }, X = async (s) => {
    const { id: e, data: o } = await Me(s, Le);
    a.accessoryId.push(e), Object.assign(o[0], { id: e }), f.value.push(...o), a.accessoryId.length && w.value.clearValidate("accessoryId");
  }, Q = (s) => {
    const e = s.id, o = a.accessoryId.findIndex((g) => g === e);
    o !== -1 && a.accessoryId.splice(o, 1);
    const r = f.value.findIndex((g) => g.id === e);
    r !== -1 && f.value.splice(r, 1), f.value.length || w.value.validateField("accessoryId");
  }, J = i, K = () => {
    he(a, { sustainable: ["startDate", "userId"] }), f.value = [], J("close");
  }, W = async () => {
    w.value.validate().then(async () => {
      if (a.id) try {
        await ke(a), D("success", "修改成功"), _.value = false;
      } catch (s) {
        console.error("修改失败", s);
      }
      else try {
        await Ye(a), D("success", "创建成功"), _.value = false;
      } catch (s) {
        console.error("创建失败", s);
      }
    });
  }, Z = y(() => R.getters.user.id);
  return x(() => Z.value, (s) => {
    a.id || (a.userId = s);
  }, { immediate: true }), c({ headerTitle: k, visible: _, formData: a, saveBtnTitle: Y, getGrantInfo: H }), (s, e) => {
    const o = fe, r = me, g = _e, p = ge, u = be, $ = ye, ee = ve, le = Ie, m = Ve, ae = we, te = Ee, I = Ce, se = De, ne = Te, re = Ne;
    return v(), A("div", qe, [l(re, { modelValue: _.value, "onUpdate:modelValue": e[14] || (e[14] = (n) => _.value = n), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "45%", onClosed: K }, { header: t(() => [l(j, { "header-title": k.value, "type-one": false }, null, 8, ["header-title"]), l(o, { plain: "", onClick: e[0] || (e[0] = (n) => _.value = false) }, { default: t(() => e[15] || (e[15] = [E("关闭")])), _: 1, __: [15] }), l(o, { type: "success", onClick: W }, { default: t(() => [E(M(Y.value), 1)]), _: 1 })]), default: t(() => [l(te, { ref_key: "formRef", ref: w, model: a, rules: C(S), class: "form-container", "label-position": "left" }, { default: t(() => [l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[16] || (e[16] = [d("span", { class: "prop-span label" }, "创建日期：", -1)])), _: 1, __: [16] }), l(r, { span: 20 }, { default: t(() => [l(p, { prop: "startDate" }, { default: t(() => [l(g, { modelValue: a.startDate, "onUpdate:modelValue": e[1] || (e[1] = (n) => a.startDate = n), clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[17] || (e[17] = [d("span", { class: "label" }, "创建人：", -1)])), _: 1, __: [17] }), l(r, { span: 20 }, { default: t(() => [l($, { modelValue: a.userId, "onUpdate:modelValue": e[2] || (e[2] = (n) => a.userId = n), options: C(L), props: { value: "id", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", placeholder: "请选择或输入创建人" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[18] || (e[18] = [d("span", { class: "prop-span label" }, "被授信人：", -1)])), _: 1, __: [18] }), l(r, { span: 20 }, { default: t(() => [l(p, { prop: "accreditingPartyId" }, { default: t(() => [l($, { modelValue: a.accreditingPartyId, "onUpdate:modelValue": e[3] || (e[3] = (n) => a.accreditingPartyId = n), options: C(L), props: { value: "id", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", placeholder: "请选择或输入被授信人" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[19] || (e[19] = [d("span", { class: "prop-span label" }, "项目：", -1)])), _: 1, __: [19] }), l(r, { span: 20 }, { default: t(() => [l(le, { modelValue: a.projectId, "onUpdate:modelValue": e[4] || (e[4] = (n) => a.projectId = n), disabled: !V.value.length, clearable: "", filterable: "", placeholder: "请选择项目" }, { default: t(() => [(v(true), A(pe, null, ce(V.value, (n) => (v(), U(ee, { key: n.id, label: n.serialNumber + "-" + n.shortName, value: n.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[20] || (e[20] = [d("span", { class: "prop-span label" }, "身份证号码：", -1)])), _: 1, __: [20] }), l(r, { span: 20 }, { default: t(() => [l(p, { prop: "idNumber" }, { default: t(() => [l(m, { modelValue: a.idNumber, "onUpdate:modelValue": e[5] || (e[5] = (n) => a.idNumber = n), modelModifiers: { trim: true }, clearable: "", placeholder: "请输入授信人身份证号码" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[21] || (e[21] = [d("div", { class: "switch-container" }, [d("span", { class: "prop-span label" }, "担保人:")], -1)])), _: 1, __: [21] }), l(r, { span: 20 }, { default: t(() => [l(p, { prop: "suretyName" }, { default: t(() => [l(m, { modelValue: a.suretyName, "onUpdate:modelValue": e[6] || (e[6] = (n) => a.suretyName = n), clearable: "", placeholder: "请输入担保人" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[22] || (e[22] = [d("span", { class: "prop-span label" }, "担保人身份证：", -1)])), _: 1, __: [22] }), l(r, { span: 20 }, { default: t(() => [l(p, { prop: "accreditingIdNumber" }, { default: t(() => [l(m, { modelValue: a.accreditingIdNumber, "onUpdate:modelValue": e[7] || (e[7] = (n) => a.accreditingIdNumber = n), modelModifiers: { trim: true }, clearable: "", placeholder: "请输入担保人身份证号码", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[23] || (e[23] = [d("span", { class: "prop-span label" }, "授信额度：", -1)])), _: 1, __: [23] }), l(r, { span: 20 }, { default: t(() => [l(p, { prop: "lineOfCredit" }, { default: t(() => [l(m, { modelValue: a.lineOfCredit, "onUpdate:modelValue": e[8] || (e[8] = (n) => a.lineOfCredit = n), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", style: { width: "100%" }, type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[24] || (e[24] = [d("span", { class: "label" }, "大写：", -1)])), _: 1, __: [24] }), l(r, { span: 20 }, { default: t(() => [l(m, { modelValue: F.value, "onUpdate:modelValue": e[9] || (e[9] = (n) => F.value = n), placeholder: "输入授信额度", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[25] || (e[25] = [d("span", { class: "prop-span label" }, "年息 (%)：", -1)])), _: 1, __: [25] }), l(r, { span: 20 }, { default: t(() => [l(p, { prop: "annualInterest" }, { default: t(() => [l(m, { modelValue: a.annualInterest, "onUpdate:modelValue": e[10] || (e[10] = (n) => a.annualInterest = n), modelModifiers: { trim: true }, clearable: "", placeholder: "请输入年息", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[26] || (e[26] = [d("span", { class: "label" }, "月息：", -1)])), _: 1, __: [26] }), l(r, { span: 20 }, { default: t(() => [l(p, { prop: "invoiceAmount" }, { default: t(() => [l(m, { modelValue: N.value, "onUpdate:modelValue": e[11] || (e[11] = (n) => N.value = n), clearable: "", placeholder: "根据年息自动计算", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[27] || (e[27] = [d("span", { class: "label" }, "日息：", -1)])), _: 1, __: [27] }), l(r, { span: 20 }, { default: t(() => [l(p, null, { default: t(() => [l(m, { modelValue: O.value, "onUpdate:modelValue": e[12] || (e[12] = (n) => O.value = n), clearable: "", placeholder: "根据年息自动计算", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[28] || (e[28] = [d("span", { class: "prop-span label" }, "有效截止日期：", -1)])), _: 1, __: [28] }), l(r, { span: 20 }, { default: t(() => [d("div", Be, [l(p, { class: "date-picker-container", prop: "closingDate" }, { default: t(() => [l(g, { modelValue: a.closingDate, "onUpdate:modelValue": e[13] || (e[13] = (n) => a.closingDate = n), "disabled-date": B, placeholder: "请选择截至日期", type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), a.startDate && a.closingDate ? (v(), A("div", Ge, [d("span", null, M(z.value), 1)])) : h("", true)])]), _: 1 })]), _: 1 }), l(u, null, { default: t(() => [l(r, { span: 4 }, { default: t(() => e[29] || (e[29] = [d("span", { class: "prop-span label" }, "附件：", -1)])), _: 1, __: [29] }), l(r, { span: 20 }, { default: t(() => [l(p, { class: "upload-container", prop: "accessoryId" }, { default: t(() => [l(ae, { "auto-upload": false, "on-change": X, "show-file-list": false, action: "#", multiple: "" }, { default: t(() => [l(o, { icon: "el-icon-upload", plain: "", size: "default", type: "primary" }, { default: t(() => e[30] || (e[30] = [E("导入")])), _: 1, __: [30] })]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), q.value ? (v(), U(u, { key: 0, style: { "margin-top": "10px" } }, { default: t(() => [l(j, { "header-title": "附件" }), l(ne, { data: f.value, border: "", "max-height": "200px" }, { default: t(() => [l(I, { label: "序号", type: "index", width: "80" }), l(I, { label: "名称", prop: "name", "show-overflow-tooltip": "" }), l(I, { align: "center", label: "上传时间", prop: "updateTime", width: "120" }), l(I, { align: "center", label: "上传状态", prop: "status", width: "120" }, { default: t((n) => [n.row.status === 1 ? (v(), U(se, { key: 0, effect: "dark", type: "success" }, { default: t(() => e[31] || (e[31] = [E("上传成功")])), _: 1, __: [31] })) : h("", true)]), _: 1 }), l(I, { align: "center", label: "操作", width: "120" }, { default: t(({ row: n }) => [l(o, { icon: "el-icon-download", size: "default", type: "warning", onClick: (oe) => C($e)(n.id) }, null, 8, ["onClick"]), l(o, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (oe) => Q(n) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["modelValue"])]);
  };
} }, el = Oe(ze, [["__scopeId", "data-v-94f548f3"]]);
export {
  el as default
};
