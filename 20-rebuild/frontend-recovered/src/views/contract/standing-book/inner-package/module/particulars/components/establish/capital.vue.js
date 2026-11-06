import { useStore as ae } from "vuex";
import { computed as I } from "vue";
import { ref as v } from "vue";
import { inject as te } from "vue";
import { reactive as le } from "vue";
import { watchEffect as L } from "vue";
import { watch as M } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as a } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as C } from "vue";
import { unref as y } from "vue";
import { createElementVNode as r } from "vue";
import { Fragment as N } from "vue";
import { renderList as F } from "vue";
import { createBlock as R } from "vue";
import { toDisplayString as A } from "vue";
import { ElButton as oe } from "element-plus";
import { ElCol as ne } from "element-plus";
import { ElDatePicker as se } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElRow as de } from "element-plus";
import { ElOption as pe } from "element-plus";
import { ElSelect as ie } from "element-plus";
import { ElInput as ue } from "element-plus";
import { ElCascader as ce } from "element-plus";
import { ElForm as me } from "element-plus";
import { ElDivider as fe } from "element-plus";
import { ElDrawer as _e } from "element-plus";
import { _ as be, gD as ve, ia as ye, e6 as D, dp as ge, j1 as w, dq as Ie, e2 as je, R as we } from "../../../../../../../../shared/runtime.js";
import { c as Ve } from "../../../../../../../../modules/data-039b7fd9.js";
const Ee = { class: "collection-container" }, Se = { style: { float: "left" } }, ke = { style: { float: "right", color: "var(--el-text-color-secondary)", "font-size": "13px" } }, Te = { __name: "capital", props: { visible: { type: Boolean }, id: { type: [String, Number] } }, emits: ["update:visible"], setup(P, { expose: z, emit: H }) {
  const V = P, O = H, E = ae(), h = I(() => E.getters.user.id), S = v(null), k = v([]), g = v(false), f = v([]), { _commonFn: i, projectInfo: u, _commonAttribute: _, projectLeaderList: q } = te("parent_data"), Q = I(() => ve.VL[u.projectAttribute] + "项目"), t = le({ attachmentId: [], assetInjectionTime: (/* @__PURE__ */ new Date()).getTime(), creatorUserId: h.value ?? null }), T = I(() => t != null && t.amount ? ye(t.amount) : "");
  L(() => {
    _.value.capitalList && (f.value = _.value.capitalList), _.value.capitalTypeList && (k.value = _.value.capitalTypeList);
  });
  const $ = async (n) => {
    try {
      const e = await w.get(`/api/contract/Injection/getPutAssetInjection/${n}`);
      console.log(e), typeof e.assetInjectionEnum == "string" && (e.assetInjectionEnum = Number(e.assetInjectionEnum)), e.capitalType = e.projectManagerScale ? "projectManagerId" : "contractSignBodyId", e.amount = e.projectManagerScale || e.contractSignBodyScale, e.creatorUserId = e.user.id || null, console.log(e), Object.assign(t, e);
    } catch (e) {
      console.error("注资回显示失败", e);
    }
  };
  L(() => {
    if (t.capitalType && t.amount) switch (t.capitalType) {
      case "contractSignBodyId":
        t.contractSignBodyScale = t.amount, t.contractSignBodyId = Number(f.value.find((n) => n.key === "contractSignBodyId").id), delete t.projectManagerScale, delete t.projectManagerId;
        break;
      case "projectManagerId":
        delete t.contractSignBodyScale, delete t.contractSignBodyId, t.projectManagerScale = t.amount, t.projectManagerId = Number(f.value.find((n) => n.key === "projectManagerId").id);
        break;
    }
  });
  const G = async () => {
    S.value.validate().then(async () => {
      var n;
      try {
        g.value = true;
        const e = Ie(t);
        (n = e == null ? void 0 : e.attachment) != null && n.length && (e.attachmentId = e.attachment.map((b) => b.id)), t.id ? await w.put("/api/contract/Injection", e) : await w.post("/api/contract/Injection", e), await je("success", "提交成功"), await i.value.getCapitalList(), await i.value.getItemRegisterInfo(), await i.value.tidyHeaderInfo(), await i.value.getUseTableData(), await i.value.getProjectSum(), D(t, { sustainable: ["assetInjectionTime", "creatorUserId"] }), B();
      } catch {
        console.error("提交失败：saveInvoice");
      } finally {
        g.value = false;
      }
    });
  }, B = () => {
    t != null && t.attachment && (t.attachment = []), O("update:visible", false);
  };
  M(() => V.visible, async (n) => {
    n && (t.projectId = u.project.id);
  }, { immediate: true }), M(() => {
    var n;
    return (n = u.project) == null ? void 0 : n.id;
  }, (n, e) => {
    n !== e && (D(t, { sustainable: ["assetInjectionTime"] }), t.creatorUserId = E.getters.user.id);
  });
  const J = (n) => {
    n.length > 1 && (t.attachment = [n[n.length - 1]]);
  };
  return z({ getCapitalItemInfo: $ }), (n, e) => {
    const b = oe, s = ne, K = se, p = re, d = de, U = pe, x = ie, c = ue, W = ce, X = me, Y = fe, Z = we, ee = _e;
    return m(), j("div", Ee, [a(ee, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": V.visible, "show-close": false, "append-to-body": "", "destroy-on-close": "", size: "40%" }, { header: l(() => [a(ge, { "header-title": t.id ? "注资编辑" : "注资创建", "type-one": false }, null, 8, ["header-title"]), a(b, { plain: "", onClick: B }, { default: l(() => e[8] || (e[8] = [C("关闭")])), _: 1, __: [8] }), a(b, { loading: g.value, type: "success", onClick: G }, { default: l(() => e[9] || (e[9] = [C("提交")])), _: 1, __: [9] }, 8, ["loading"])]), default: l(() => [a(X, { ref_key: "formRef", ref: S, model: t, rules: y(Ve), class: "form-container", "label-position": "left" }, { default: l(() => [a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[10] || (e[10] = [r("span", { class: "prop-span label" }, "注资日期：", -1)])), _: 1, __: [10] }), a(s, { span: 20 }, { default: l(() => [a(p, { prop: "assetInjectionTime" }, { default: l(() => [a(K, { modelValue: t.assetInjectionTime, "onUpdate:modelValue": e[0] || (e[0] = (o) => t.assetInjectionTime = o), clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[11] || (e[11] = [r("span", { class: "prop-span label" }, "注资人：", -1)])), _: 1, __: [11] }), a(s, { span: 20 }, { default: l(() => [a(p, { prop: "capitalType" }, { default: l(() => [a(x, { modelValue: t.capitalType, "onUpdate:modelValue": e[1] || (e[1] = (o) => t.capitalType = o), modelModifiers: { number: true }, disabled: t == null ? void 0 : t.id, clearable: "" }, { default: l(() => [(m(true), j(N, null, F(f.value, (o) => (m(), R(U, { key: o.key, label: o.label, value: o.key }, { default: l(() => [r("span", Se, A(o.label), 1), r("span", ke, A(o.key === "contractSignBodyId" ? "签约主体" : "项目经理"), 1)]), _: 2 }, 1032, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[12] || (e[12] = [r("span", { class: "prop-span label" }, "项目类型：", -1)])), _: 1, __: [12] }), a(s, { span: 20 }, { default: l(() => [a(c, { "model-value": Q.value, disabled: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[13] || (e[13] = [r("span", { class: "prop-span label" }, "项目：", -1)])), _: 1, __: [13] }), a(s, { span: 20 }, { default: l(() => [a(c, { "model-value": y(u).project.serialNumber + " - " + y(u).project.shortName, disabled: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[14] || (e[14] = [r("span", { class: "prop-span label" }, "注资金额：", -1)])), _: 1, __: [14] }), a(s, { span: 20 }, { default: l(() => [a(p, { prop: "amount" }, { default: l(() => [a(c, { modelValue: t.amount, "onUpdate:modelValue": e[2] || (e[2] = (o) => t.amount = o), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[15] || (e[15] = [r("span", { class: "label" }, "大写：", -1)])), _: 1, __: [15] }), a(s, { span: 20 }, { default: l(() => [a(c, { modelValue: T.value, "onUpdate:modelValue": e[3] || (e[3] = (o) => T.value = o), placeholder: "输入注资金额", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[16] || (e[16] = [r("span", { class: "prop-span label" }, "注资类型：", -1)])), _: 1, __: [16] }), a(s, { span: 20 }, { default: l(() => [a(p, { prop: "assetInjectionEnum" }, { default: l(() => [a(x, { modelValue: t.assetInjectionEnum, "onUpdate:modelValue": e[4] || (e[4] = (o) => t.assetInjectionEnum = o), modelModifiers: { number: true }, clearable: "", placeholder: "请选择注资类型" }, { default: l(() => [(m(true), j(N, null, F(k.value, (o) => (m(), R(U, { key: o.id, label: o.label, value: o.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[17] || (e[17] = [r("span", { class: "prop-span label" }, "收款银行：", -1)])), _: 1, __: [17] }), a(s, { span: 20 }, { default: l(() => [a(p, { prop: "collectionDepositBank" }, { default: l(() => [a(c, { modelValue: t.collectionDepositBank, "onUpdate:modelValue": e[5] || (e[5] = (o) => t.collectionDepositBank = o), clearable: "", placeholder: "请输入收款银行" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), a(d, null, { default: l(() => [a(s, { span: 4 }, { default: l(() => e[18] || (e[18] = [r("span", { class: "prop-span label" }, "创建人：", -1)])), _: 1, __: [18] }), a(s, { span: 20 }, { default: l(() => [a(p, { prop: "creatorUserId" }, { default: l(() => [a(W, { modelValue: t.creatorUserId, "onUpdate:modelValue": e[6] || (e[6] = (o) => t.creatorUserId = o), options: y(q), props: { value: "id", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", placeholder: "请选择或输入创建人" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), a(Y, null, { default: l(() => e[19] || (e[19] = [r("span", { class: "title" }, "附件", -1)])), _: 1, __: [19] }), a(Z, { files: t.attachment, "onUpdate:files": [e[7] || (e[7] = (o) => t.attachment = o), J], "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model-value"])]);
  };
} }, Le = be(Te, [["__scopeId", "data-v-e6dfd1a3"]]);
export {
  Le as default
};
