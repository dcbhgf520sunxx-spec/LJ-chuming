import { ref as c } from "vue";
import { watch as J } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as i } from "vue";
import { unref as m } from "vue";
import { Fragment as A } from "vue";
import { renderList as O } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as z } from "vue";
import { createBlock as K } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as D } from "vue";
import { createCommentVNode as Q } from "vue";
import { ElMessage as F } from "element-plus";
import { ElMessageBox as X } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElForm as ee } from "element-plus";
import { ElImage as te } from "element-plus";
import { ElInputNumber as se } from "element-plus";
import { ElTag as oe } from "element-plus";
import { l as T, _ as ae, m as le, G as x, hD as L, V as ne, hE as ce, am as C, d as I } from "../../../../shared/runtime.js";
import { _ as ie } from "../../../../modules/mes-bridge-enum-radio-5a510e87.js";
function re(S) {
  return T({ url: "api/config/SectionSteelControl/SectionSteelControlList", method: "get", params: S });
}
function ue() {
  return T({ url: "api/config/SectionSteelControl/getSectionSteelLastSubjects", method: "get" });
}
function de(S) {
  return T({ url: "api/config/SectionSteelControl/saveSectionSteelControl", method: "post", data: S });
}
const pe = { class: "app-container" }, me = { key: 0, class: "wms-material-compare" }, fe = { class: "header" }, _e = { class: "content" }, Ce = { style: { display: "flex", "align-items": "center" } }, ye = { class: "error-list" }, Se = { style: { width: "140px", display: "inline-block", "text-align": "center" } }, ge = { key: 1 }, ve = { __name: "index", setup(S) {
  const { user: R } = le(["user"]), W = c(), g = c([]), v = c([]), P = c([]), N = c([]), f = c(R.value.mesProductEnum[0]), B = c([]), h = c([]), w = c({});
  J(() => f.value, () => {
    M(), k();
  });
  function b(e, s) {
    var r;
    w.value[`${e.name}`] = !I(e, h.value[s]) || !I(e.map, h.value[s].map) || !I(e == null ? void 0 : e.wmsClassifyIds, (r = h.value[s]) == null ? void 0 : r.wmsClassifyIds);
  }
  async function k() {
    if (!x(L.get)) return;
    await j(), await M();
    const e = await re({ mesProductEnum: f.value });
    B.value = e, h.value = ne(e), w.value = {};
  }
  k();
  async function M() {
    g.value = [], v.value = [];
    const { content: e } = await ce({ mesProductEnum: f.value });
    e.filter((o) => o.basicClass === C.SECTION_STEEL.V).reduce((o, n) => o.concat(n.links), []).forEach((o) => {
      console.log(o, o.keyword), g.value.findIndex((n) => n.keyword === o.keyword) < 0 && g.value.push(o);
    }), e.filter((o) => o.basicClass === C.STEEL_PLATE.V).reduce((o, n) => o.concat(n.links), []).forEach((o) => {
      v.value.findIndex((n) => n.keyword === o.keyword) < 0 && v.value.push(o);
    });
  }
  async function j() {
    const e = await ue();
    P.value = e.filter((s) => s.basicClass === C.SECTION_STEEL.V), N.value = e.filter((s) => s.basicClass === C.STEEL_PLATE.V);
  }
  async function q(e) {
    var s, r;
    if (!((s = e.mesSectionSpecifications) != null && s.length) || !((r = e.wmsClassifyIds) != null && r.length)) return F.error("请填写必选项"), false;
    try {
      const a = {};
      for (const l in e.map) G(l) ? a["errorBig" + l] = e.map[l] : a["error" + l.toUpperCase()] = e.map[l];
      await X.confirm("确定修改" + e.name + "截面规格对照配置吗？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "info" }), await de({ ...e, wmsClassifyIds: e.wmsClassifyIds, mesSectionSpecification: e.mesSectionSpecifications, ...a, mesProductEnum: f.value }), F.success("保存成功"), k();
    } catch (a) {
      console.log("error:", a);
    }
  }
  function G(e) {
    return /^[A-Z]$/.test(e);
  }
  return (e, s) => {
    const r = $("common-tip-button"), a = $("common-select"), l = Y, o = ee, n = te, H = se, Z = oe;
    return u(), p("div", pe, [i(m(ie), { modelValue: f.value, "onUpdate:modelValue": s[0] || (s[0] = (t) => f.value = t), ref: "mesBridgeEnumRadioRef", style: { "margin-bottom": "10px" } }, null, 8, ["modelValue"]), m(x)(m(L).get) ? (u(), p("div", me, [(u(true), p(A, null, O(B.value, (t, V) => (u(), p("div", { class: "box", key: t.name }, [_("div", fe, [_("span", null, z(t.name) + "对照表", 1), m(x)(m(L).edit) ? (u(), K(r, { key: 0, type: "success", size: "small", "show-tip": "", disabled: !w.value[t.name], onClick: (d) => q(t) }, { default: y(() => s[1] || (s[1] = [D("保存")])), _: 2, __: [1] }, 1032, ["disabled", "onClick"])) : Q("", true)]), _("div", _e, [i(o, { ref_for: true, ref_key: "formRef", ref: W, style: { "max-width": "300px" }, "label-width": "auto" }, { default: y(() => [i(l, { prop: "mes", label: "MES截面规格", class: "form-label-require" }, { default: y(() => [i(a, { modelValue: t.mesSectionSpecifications, "onUpdate:modelValue": (d) => t.mesSectionSpecifications = d, options: t.basicClass === m(C).SECTION_STEEL.V ? g.value : v.value, dataStructure: { key: "keyword", label: "keyword", value: "keyword" }, type: "other", size: "small", filterable: "", clearable: "", multiple: "", placeholder: "截面规格", onChange: (d) => b(t, V), style: { width: "270px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 2 }, 1024), i(l, { prop: "wms", label: "WMS科目名称", class: "form-label-require" }, { default: y(() => [i(a, { modelValue: t.wmsClassifyIds, "onUpdate:modelValue": (d) => t.wmsClassifyIds = d, options: t.basicClass === m(C).SECTION_STEEL.V ? P.value : N.value, dataStructure: { key: "id", label: "name", value: "id" }, type: "other", size: "small", clearable: "", filterable: "", multiple: "", placeholder: "科目名称", onChange: (d) => b(t, V), style: { width: "270px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 2 }, 1024)]), _: 2 }, 1536), _("div", Ce, [i(n, { style: { width: "200px", height: "200px" }, src: t.image, fit: "scale-down" }, { error: y(() => [_("span", { role: "status", style: { padding: "12px", color: "#909399" } }, "本地缺少原截面示意图，请补齐原附件")]), _: 1 }, 8, ["src"]), _("div", ye, [(u(true), p(A, null, O(t.map, (d, E) => (u(), p("span", { key: E, style: { "margin-bottom": "5px", display: "flex", "align-items": "center" } }, [_("span", Se, z(E) + " ±误差（mm）", 1), i(H, { modelValue: t.map[E], "onUpdate:modelValue": (U) => t.map[E] = U, min: 0, max: 999999999, "controls-position": "right", onChange: (U) => b(t, V) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]))), 128))])])])]))), 128))])) : (u(), p("div", ge, [i(Z, { type: "info" }, { default: y(() => s[2] || (s[2] = [D("* 暂没有权限")])), _: 1, __: [2] })]))]);
  };
} }, be = ae(ve, [["__scopeId", "data-v-fcdb3062"]]);
export {
  be as default
};
