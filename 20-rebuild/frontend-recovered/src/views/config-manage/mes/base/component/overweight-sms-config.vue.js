import { inject as ne } from "vue";
import { ref as f } from "vue";
import { onMounted as oe } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as se } from "vue";
import { openBlock as t } from "vue";
import { createBlock as u } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as M } from "vue";
import { createTextVNode as C } from "vue";
import { unref as d } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as ie } from "vue";
import { createVNode as r } from "vue";
import { toDisplayString as k } from "vue";
import { createCommentVNode as B } from "vue";
import { ElMessage as ue } from "element-plus";
import { ElNotification as de } from "element-plus";
import { InfoFilled as re } from "@element-plus/icons-vue";
import { ElIcon as me } from "element-plus";
import { ElTooltip as pe } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElInput as _e } from "element-plus";
import { ElInputNumber as fe } from "element-plus";
import { ElFormItem as he } from "element-plus";
import { ElForm as ge } from "element-plus";
import { ElCard as ve } from "element-plus";
import { vLoading as ye } from "element-plus";
import { B as ke, C as be } from "../../../../../modules/base-6bc46ddf.js";
import { _ as xe, o as we, fo as N, i as S, V as H, aV as Ee, G as D, aw as Ve, v as Ce } from "../../../../../shared/runtime.js";
import { u as Se } from "../../../../../modules/index-9d220fe1.js";
import "../../../../../modules/use-users-4d979987.js";
const Te = { class: "clearfix" }, Ie = { style: { float: "right" } }, Me = { style: { display: "inline-block", cursor: "pointer" } }, Ne = { key: 1 }, Re = { key: 1 }, Ue = { key: 1 }, We = { key: 1 }, ze = { key: 1 }, Be = { __name: "overweight-sms-config", setup(He) {
  const T = ne("permission"), { maxHeight: L } = we({ extraBox: [".el-card__header", ".el-form"], wrapperBox: [".app-container", ".el-card__body"], minHeight: 300, extraHeight: 25 }), F = { id: [{ required: true, message: "请选择过磅短信接收人", trigger: "change" }], phone: [{ required: true, message: "请填写手机号", trigger: "blur" }, { pattern: Ce, message: "请填写正确的手机号", trigger: "blur" }] }, { tableValidate: j, cleanUpData: q, wrongCellMask: G } = Ve({ rules: F }), O = f(), m = f(false), p = f([]), v = f({ userChecks: [], weightTypeEnum: N.NET_WEIGHT.V, maxWeight: void 0 }), i = f(v.value), b = f(false), I = f(false);
  oe(() => {
    R();
  });
  async function R() {
    b.value = true;
    try {
      const { userChecks: s, weightTypeEnum: e, maxWeight: n } = await ke();
      p.value = s.map((o) => {
        var h, x;
        return o.workshopIds = (h = o.workshops) == null ? void 0 : h.map((c) => c == null ? void 0 : c.id), o.workshopNames = (x = o.workshops) == null ? void 0 : x.map((c) => c == null ? void 0 : c.name).join("、"), o.workshopNames || (o.workshopNames = "全部车间"), o;
      }), i.value = { userChecks: s, weightTypeEnum: S(e) ? e : void 0, maxWeight: S(n) ? n : void 0 }, v.value = { userChecks: H(p.value), weightTypeEnum: S(e) ? e : void 0, maxWeight: S(n) ? n : void 0 };
    } catch (s) {
      console.log("获取过磅超标短信接收人", s);
    } finally {
      b.value = false;
    }
  }
  function P() {
    p.value.length === 0 && U(), m.value = true;
  }
  function $() {
    p.value = H(v.value.userChecks), i.value.weightTypeEnum = v.value.weightTypeEnum, i.value.maxWeight = v.value.maxWeight, m.value = false;
  }
  function A(s) {
    p.value.splice(s, 1);
  }
  function U() {
    p.value.push({ id: void 0, name: "", phone: "", workshopIds: [] });
  }
  function J(s, e) {
    e.phone = s.phone;
  }
  async function K() {
    try {
      const { validResult: s, dealList: e } = j(p.value);
      if (s) {
        if (q(e), e.filter((n) => {
          var o;
          return ((o = n.workshopIds) == null ? void 0 : o.length) === 0;
        }).length > 1) return ue.error("最多只能保留一条全部车间的配置"), false;
        i.value.userChecks = e.map((n) => {
          var o;
          return n.workshops = (o = n.workshopIds) == null ? void 0 : o.map((h) => ({ id: h })), n;
        }), I.value = true, await be(i.value), de({ title: "过磅超标短信接收人配置成功", type: "success", duration: 2500 }), m.value = false, R();
      }
    } catch (s) {
      console.log("设置过磅超标短信接收人", s);
    } finally {
      I.value = false;
    }
  }
  return (s, e) => {
    const n = V("common-button"), o = V("common-tip-button"), h = re, x = me, c = pe, w = ce, Q = _e, X = V("common-table"), Y = fe, W = he, Z = V("common-radio"), ee = ge, ae = ve, te = se("permission"), z = ye;
    return t(), u(ae, { shadow: "always" }, { header: l(() => [y("div", Te, [e[5] || (e[5] = y("span", { class: "card-title" }, "过磅配置", -1)), y("div", Ie, [m.value ? (t(), g(ie, { key: 1 }, [r(n, { size: "default", type: "warning", onClick: $, style: { "margin-right": "6px" } }, { default: l(() => e[3] || (e[3] = [C("取消编辑")])), _: 1, __: [3] }), r(o, { loading: I.value, "show-tip": "", size: "default", type: "primary", onClick: K }, { default: l(() => e[4] || (e[4] = [C(" 保存 ")])), _: 1, __: [4] }, 8, ["loading"])], 64)) : M((t(), u(n, { key: 0, size: "default", type: "primary", onClick: P }, { default: l(() => e[2] || (e[2] = [C(" 编辑 ")])), _: 1, __: [2] })), [[te, d(T).overweightSMSRecipientEdit]])])])]), default: l(() => [M((t(), u(X, { data: p.value, "return-source-data": "", "cell-class-name": d(G), maxHeight: d(L) - 190, "show-empty-symbol": false, style: { "margin-bottom": "20px" } }, { default: l(() => [r(w, { prop: "workshopIds", label: "车间" }, { header: l(() => [r(c, { class: "item", effect: "light", content: `1.不选择车间时默认为所有车间。
            2.只能有一条全部车间的配置。`, placement: "right" }, { default: l(() => [y("div", Me, [e[6] || (e[6] = y("span", { class: "card-title" }, "车间", -1)), r(x, { style: { color: "#909399", "margin-left": "5px" } }, { default: l(() => [r(h)]), _: 1 })])]), _: 1 })]), default: l(({ row: a, $index: _ }) => [m.value ? (t(), u(d(Ee), { key: Math.random(), modelValue: a.workshopIds, "onUpdate:modelValue": (E) => a.workshopIds = E, disabledVal: p.value.filter((E, le) => le !== _).map((E) => E.workshopIds).flat(1 / 0), size: "default", multiple: "", collapseTags: false, clearable: "", placeholder: "全部车间", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledVal"])) : (t(), g("span", Ne, k(a.workshopNames), 1))]), _: 1 }), r(w, { prop: "id", label: "短信接收人", align: "center", width: "116" }, { default: l(({ row: a }) => [m.value ? (t(), u(d(Se), { key: 0, modelValue: a.id, "onUpdate:modelValue": (_) => a.id = _, size: "default", placeholder: "短信接收人", style: { width: "100%" }, onChange: (_) => J(_, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (t(), g("span", Re, k(a.name), 1))]), _: 1 }), r(w, { prop: "phone", label: "手机号码", align: "center", width: "112" }, { default: l(({ row: a }) => [m.value ? (t(), u(Q, { key: 0, modelValue: a.phone, "onUpdate:modelValue": (_) => a.phone = _, size: "default", maxlength: "11", placeholder: "手机号码", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), g("span", Ue, k(a.phone), 1))]), _: 1 }), m.value ? (t(), u(w, { key: 0, label: "操作", width: "80", align: "center" }, { default: l(({ $index: a }) => [a + 1 === p.value.length ? (t(), u(n, { key: 0, size: "default", type: "primary", icon: "el-icon-plus", onClick: U, style: { padding: "6px" } })) : B("", true), r(n, { size: "default", type: "danger", icon: "el-icon-delete", onClick: (_) => A(a), style: { padding: "6px" } }, null, 8, ["onClick"])]), _: 1 })) : B("", true)]), _: 1 }, 8, ["data", "cell-class-name", "maxHeight"])), [[z, b.value]]), M((t(), u(ee, { ref_key: "formRef", ref: O, model: i.value, "label-width": "160px" }, { default: l(() => [r(W, { label: "过磅超标重量允许值：", prop: "maxWeight" }, { default: l(() => [d(D)(d(T).overweightSMSRecipientEdit) && m.value ? (t(), u(Y, { key: 0, modelValue: i.value.maxWeight, "onUpdate:modelValue": e[0] || (e[0] = (a) => i.value.maxWeight = a), modelModifiers: { number: true }, min: 0, max: 100, step: 1, precision: 2, placeholder: "比例", controls: false, style: { width: "80px" }, class: "input-underline" }, null, 8, ["modelValue"])) : (t(), g("span", We, k(i.value.maxWeight), 1)), e[7] || (e[7] = C(" % "))]), _: 1, __: [7] }), r(W, { label: "过磅比较重量：", prop: "weightTypeEnum" }, { default: l(() => [d(D)(d(T).overweightSMSRecipientEdit) && m.value ? (t(), u(Z, { key: 0, modelValue: i.value.weightTypeEnum, "onUpdate:modelValue": e[1] || (e[1] = (a) => i.value.weightTypeEnum = a), options: d(N).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])) : (t(), g("span", ze, k(d(N).VL[i.value.weightTypeEnum]), 1))]), _: 1 })]), _: 1 }, 8, ["model"])), [[z, b.value]])]), _: 1 });
  };
} }, Ge = xe(Be, [["__scopeId", "data-v-e16a5f3d"]]);
export {
  Ge as default
};
