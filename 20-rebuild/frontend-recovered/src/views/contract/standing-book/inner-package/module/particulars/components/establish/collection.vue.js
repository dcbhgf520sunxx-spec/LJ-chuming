import { useRoute as Z } from "vue-router";
import { reactive as $ } from "vue";
import { computed as x } from "vue";
import { inject as N } from "vue";
import { ref as I } from "vue";
import { watch as R } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as l } from "vue";
import { withCtx as t } from "vue";
import { createTextVNode as r } from "vue";
import { unref as k } from "vue";
import { withDirectives as m } from "vue";
import { createBlock as B } from "vue";
import { createCommentVNode as le } from "vue";
import { Fragment as P } from "vue";
import { renderList as S } from "vue";
import { createElementVNode as te } from "vue";
import { ElButton as ae } from "element-plus";
import { ElCol as oe } from "element-plus";
import { ElDatePicker as ne } from "element-plus";
import { ElFormItem as se } from "element-plus";
import { ElRow as de } from "element-plus";
import { ElInput as ue } from "element-plus";
import { ElOption as ie } from "element-plus";
import { ElSelect as pe } from "element-plus";
import { ElCascader as re } from "element-plus";
import { ElForm as ce } from "element-plus";
import { ElDivider as me } from "element-plus";
import { ElDrawer as fe } from "element-plus";
import { _ as _e, kU as be, ia as ve, e6 as M, dp as Ve, iv as ye, kV as ge, bV as we, dq as ke, kW as Ue, e2 as je, R as Ie } from "../../../../../../../../shared/runtime.js";
import { a as Be } from "../../../../../../../../modules/data-039b7fd9.js";
const De = { class: "collection-container" }, Ee = { class: "prop-span label" }, Ae = { class: "prop-span label" }, Ce = { class: "label" }, xe = { class: "label" }, Ne = { class: "prop-span label" }, Re = { class: "label" }, Pe = { class: "prop-span label" }, Se = { class: "prop-span label" }, Me = { class: "label" }, Le = { class: "prop-span label" }, Fe = { class: "label" }, Oe = { class: "prop-span label" }, Te = { __name: "collection", props: { visible: { type: Boolean } }, emits: ["update:visible"], setup(L, { emit: F }) {
  const v = Z(), V = new be(), D = L, a = $({ accessoryId: [], collectionDate: (/* @__PURE__ */ new Date()).getTime() }), E = x(() => a != null && a.collectionAmount ? ve(a.collectionAmount) : ""), O = x(() => V.get("bk_" + v.fullPath) || []), T = F, { projectInfo: y } = N("info_parent_data"), { _commonFn: b, projectLeaderList: h } = N("parent_data"), A = I(null), U = I(false), q = I([]), z = async () => {
    try {
      const s = await ge({ projectId: y.project.id }), { projectName: e, projectAttribute: u, collectionUnit: n, projectManagerName: j, userId: f, paymentDepositBank: p, paymentUnit: _, collectionUnitId: g, collectionAmountSum: w } = s;
      Object.assign(a, { projectName: e, projectAttribute: u, collectionUnit: n, projectManagerName: j, writtenById: f, paymentDepositBank: p, paymentUnit: _, collectionUnitId: g, collectionAmountSum: we(w) });
    } catch (s) {
      console.error("获取收款列表失败" + s);
    }
  }, J = async () => {
    A.value.validate().then(async () => {
      var s, e;
      try {
        U.value = true;
        const u = ke(a);
        (s = u == null ? void 0 : u.attachment) != null && s.length && (u.accessoryId = u.attachment.map((n) => n.id)), await Ue(u), je("success", "填报成功"), await b.value.getProjectSum(), await b.value.getExpendIdDetail(), (e = b == null ? void 0 : b.value) != null && e.getCollectionRecordList && await b.value.getCollectionRecordList(), M(a, { sustainable: ["collectionDate"] }), q.value = [], C();
      } catch (u) {
        console.error("发起填报失败" + u);
      } finally {
        U.value = false;
      }
    });
  }, C = () => {
    a != null && a.attachment && (a.attachment = []), T("update:visible", false);
  };
  R(() => D.visible, async (s) => {
    s && (a.projectManagerId = y.projectManagerId, a.projectId = y.project.id, await z());
  }, { immediate: true }), R(() => {
    var s;
    return (s = y.project) == null ? void 0 : s.id;
  }, (s, e) => {
    s !== e && M(a, { sustainable: ["collectionDate"] });
  });
  const H = (s) => {
    s.length > 1 && (a.attachment = [s[s.length - 1]]);
  }, K = (s) => {
    let e = [];
    V.get("bk_" + v.fullPath) && (e = JSON.parse(JSON.stringify(V.get("bk_" + v.fullPath)))), e.findIndex((u) => u.label === s) < 0 && e.push({ label: s, value: s }), V.remove("bk_" + v.fullPath), V.set("bk_" + v.fullPath, e);
  };
  return (s, e) => {
    const u = ae, n = oe, j = ne, f = se, p = de, _ = ue, g = ie, w = pe, Q = re, W = ce, G = me, X = Ie, Y = fe, c = ee("ellipsis");
    return d(), i("div", De, [l(Y, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": D.visible, "show-close": false, "destroy-on-close": "", size: "40%" }, { header: t(() => [l(Ve, { "type-one": false, "header-title": "收款填报" }), l(u, { plain: "", onClick: C }, { default: t(() => e[12] || (e[12] = [r("关闭")])), _: 1, __: [12] }), l(u, { loading: U.value, type: "success", onClick: J }, { default: t(() => e[13] || (e[13] = [r("创建")])), _: 1, __: [13] }, 8, ["loading"])]), default: t(() => [l(W, { ref_key: "formRef", ref: A, model: a, rules: k(Be), class: "form-container", "label-position": "left" }, { default: t(() => [l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Ee, e[14] || (e[14] = [r("收款日期：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, { prop: "collectionDate" }, { default: t(() => [l(j, { modelValue: a.collectionDate, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.collectionDate = o), clearable: "", placeholder: "请选择日期", "prefix-icon": "", type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Ae, e[15] || (e[15] = [r("项目：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, { prop: "date" }, { default: t(() => [l(_, { modelValue: a.projectName, "onUpdate:modelValue": e[1] || (e[1] = (o) => a.projectName = o), disabled: true, clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), a.projectAttribute === 3 ? (d(), B(p, { key: 0 }, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Ce, e[16] || (e[16] = [r("项目经理：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(_, { "model-value": k(y).projectManagerName || "无", disabled: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })) : le("", true), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", xe, e[17] || (e[17] = [r("累计已收款：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(_, { modelValue: a.collectionAmountSum, "onUpdate:modelValue": e[2] || (e[2] = (o) => a.collectionAmountSum = o), disabled: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Ne, e[18] || (e[18] = [r("本次收款：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, { prop: "collectionAmount" }, { default: t(() => [l(_, { modelValue: a.collectionAmount, "onUpdate:modelValue": e[3] || (e[3] = (o) => a.collectionAmount = o), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Re, e[19] || (e[19] = [r("大写：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(_, { modelValue: E.value, "onUpdate:modelValue": e[4] || (e[4] = (o) => E.value = o), placeholder: "输入本次收款", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Pe, e[20] || (e[20] = [r("收款类型：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, { prop: "collectionMode" }, { default: t(() => [l(w, { modelValue: a.collectionMode, "onUpdate:modelValue": e[5] || (e[5] = (o) => a.collectionMode = o), clearable: "", placeholder: "请选择收款类型" }, { default: t(() => [(d(true), i(P, null, S(k(ye).V, (o) => (d(), B(g, { key: o.K, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Se, e[21] || (e[21] = [r("付款单位：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, { prop: "paymentUnit" }, { default: t(() => [l(_, { modelValue: a.paymentUnit, "onUpdate:modelValue": e[6] || (e[6] = (o) => a.paymentUnit = o), clearable: "", placeholder: "请输入付款单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Me, e[22] || (e[22] = [r("付款银行：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, null, { default: t(() => [l(_, { modelValue: a.paymentDepositBank, "onUpdate:modelValue": e[7] || (e[7] = (o) => a.paymentDepositBank = o), clearable: "", placeholder: "请输入付款银行" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Le, e[23] || (e[23] = [r("收款银行：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, { prop: "collectionDepositBank" }, { default: t(() => [l(w, { modelValue: a.collectionDepositBank, "onUpdate:modelValue": e[8] || (e[8] = (o) => a.collectionDepositBank = o), filterable: "", "allow-create": "", placeholder: "收款银行", style: { width: "100%" }, onChange: K }, { default: t(() => [(d(true), i(P, null, S(O.value, (o) => (d(), B(g, { key: o.value, label: o.label, value: o.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Fe, e[24] || (e[24] = [r("收款单位：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, null, { default: t(() => [l(_, { modelValue: a.collectionUnit, "onUpdate:modelValue": e[9] || (e[9] = (o) => a.collectionUnit = o), clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => [m((d(), i("span", Oe, e[25] || (e[25] = [r("创建人：")]))), [[c]])]), _: 1 }), l(n, { span: 20 }, { default: t(() => [l(f, { prop: "writtenById" }, { default: t(() => [l(Q, { modelValue: a.writtenById, "onUpdate:modelValue": e[10] || (e[10] = (o) => a.writtenById = o), options: k(h), props: { value: "id", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", placeholder: "请选择或输入创建人" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), l(G, null, { default: t(() => e[26] || (e[26] = [te("span", { class: "title" }, "附件", -1)])), _: 1, __: [26] }), l(X, { files: a.attachment, "onUpdate:files": [e[11] || (e[11] = (o) => a.attachment = o), H], "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model-value"])]);
  };
} }, Je = _e(Te, [["__scopeId", "data-v-e583924d"]]);
export {
  Je as default
};
