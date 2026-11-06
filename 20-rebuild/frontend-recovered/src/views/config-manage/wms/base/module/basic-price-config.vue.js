import { inject as I } from "vue";
import { ref as d } from "vue";
import { computed as x } from "vue";
import { onMounted as K } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as l } from "vue";
import { createBlock as m } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as c } from "vue";
import { createCommentVNode as P } from "vue";
import { createElementBlock as w } from "vue";
import { Fragment as W } from "vue";
import { createTextVNode as E } from "vue";
import { withDirectives as N } from "vue";
import { unref as f } from "vue";
import { toDisplayString as C } from "vue";
import { ElNotification as S } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElForm as Y } from "element-plus";
import { ElCard as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { ho as ae, ht as te, i as b, V as le, cJ as z, aw as oe, hu as ie } from "../../../../../shared/runtime.js";
import { u as se } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
import { j as ne } from "../../../../../modules/judgeSameValue-9683bdce.js";
const re = { class: "clearfix" }, ce = { style: { float: "right" } }, ue = { key: 1 }, de = { key: 1 }, me = { key: 1 }, we = { __name: "basic-price-config", setup(pe) {
  ae();
  const B = I("permission");
  d(), d();
  const y = d({ list: [{}] }), s = d({ list: [{}] }), L = { basicClass: [{ required: true, message: "请选择物料类型", trigger: "change" }], minPrice: [{ required: true, message: "请输入最小值", trigger: "blur" }] }, { tableValidate: U, wrongCellMask: D } = oe({ rules: L }), g = d(false), u = d(false), t = d(false);
  x(() => {
    var a;
    return ne(s.value.list, (a = y.value) == null ? void 0 : a.list);
  });
  const R = x(() => g.value || u.value);
  K(() => {
    k();
  });
  async function k() {
    g.value = true;
    try {
      const a = await te();
      if (b(a)) {
        const o = le(a), n = [];
        o.forEach((r) => {
          n.push(r);
        }), s.value.list = n, y.value.list = JSON.parse(JSON.stringify(s.value.list));
      }
    } catch (a) {
      console.log("wms基础配置", a);
    } finally {
      g.value = false;
    }
  }
  function J() {
    t.value = true;
  }
  function M() {
    s.value.list.push({}), t.value = true;
  }
  function j(a) {
    s.value.list.splice(a, 1);
  }
  function O() {
    s.value.list = JSON.parse(JSON.stringify(y.value.list)), t.value = false;
  }
  async function q() {
    let a = s.value.list.filter((r) => b(r.minPrice) && r.minPrice > 0);
    const { validResult: o, dealList: n } = U(a);
    if (o) {
      a = n;
      try {
        u.value = true, await ie(a), S({ title: "单价异常提醒配置设置成功", type: "success", duration: 2500 }), k(), se("wmsConfig"), t.value = false;
      } catch {
        S({ title: "单价异常提醒配置设置失败", type: "error", duration: 2500 });
      } finally {
        u.value = false;
      }
    }
  }
  return (a, o) => {
    const n = _("common-button"), r = _("common-tip-button"), T = _("common-select"), v = X, V = _("common-input-number"), F = _("common-table"), $ = Y, A = Z, G = Q("permission"), H = ee;
    return l(), m(A, { shadow: "always" }, { header: i(() => [h("div", re, [o[2] || (o[2] = h("span", { class: "card-title" }, "“单价异常提醒”配置", -1)), h("span", ce, [c(n, { loading: u.value, size: "default", type: "primary", icon: "el-icon-plus", style: { "margin-right": "5px" }, onClick: M }, null, 8, ["loading"]), t.value ? P("", true) : (l(), m(r, { key: 0, loading: u.value, disabled: t.value, size: "default", type: "warning", icon: "el-icon-edit", onClick: J }, null, 8, ["loading", "disabled"])), t.value ? (l(), w(W, { key: 1 }, [c(n, { loading: u.value, size: "default", type: "warning", style: { "margin-right": "5px", "margin-left": "0" }, onClick: O }, { default: i(() => o[0] || (o[0] = [E("取消")])), _: 1, __: [0] }, 8, ["loading"]), N((l(), m(r, { loading: u.value, "show-tip": "", size: "default", type: "primary", onClick: q }, { default: i(() => o[1] || (o[1] = [E(" 保存 ")])), _: 1, __: [1] }, 8, ["loading"])), [[G, f(B).basicPriceConfigEdit]])], 64)) : P("", true)])])]), default: i(() => [N((l(), m($, { disabled: R.value, model: s.value, "label-position": "left", "label-width": "130px" }, { default: i(() => [c(F, { data: s.value.list, "empty-text": "暂无数据", "max-height": 500, "cell-class-name": f(D), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: i(() => [c(v, { key: "basicClass", prop: "basicClass", "show-overflow-tooltip": true, width: "120", align: "center", label: "基础类型" }, { default: i((e) => [t.value ? (l(), m(T, { key: 0, modelValue: e.row.basicClass, "onUpdate:modelValue": (p) => e.row.basicClass = p, options: f(z).ENUM, clearable: "", placeholder: "基础类型", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (l(), w("span", ue, C(f(z).VL[e.row.basicClass]), 1))]), _: 1 }), c(v, { key: "minPrice", prop: "minPrice", "show-overflow-tooltip": true, label: "最小值", align: "center" }, { default: i((e) => [t.value ? (l(), m(V, { key: 0, modelValue: e.row.minPrice, "onUpdate:modelValue": (p) => e.row.minPrice = p, max: e.row.maxPrice || 999999999999, "controls-position": "right", size: "default", placeholder: "请输入最小值", style: { width: "100%" }, min: 1, precision: 2 }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])) : (l(), w("span", de, C(f(b)(e.row.minPrice) ? e.row.minPrice : "-"), 1))]), _: 1 }), c(v, { key: "maxPrice", prop: "maxPrice", "show-overflow-tooltip": true, label: "最大值", align: "center" }, { default: i((e) => [t.value ? (l(), m(V, { key: 0, modelValue: e.row.maxPrice, "onUpdate:modelValue": (p) => e.row.maxPrice = p, max: 999999999999, "controls-position": "right", size: "default", placeholder: "请输入最大值", style: { width: "100%" }, min: e.row.minPrice || 1, precision: 2 }, null, 8, ["modelValue", "onUpdate:modelValue", "min"])) : (l(), w("span", me, C(f(b)(e.row.maxPrice) ? e.row.maxPrice : "-"), 1))]), _: 1 }), c(v, { label: "操作", align: "center", width: "65" }, { default: i((e) => [c(n, { size: "default", disabled: !t.value, icon: "el-icon-delete", type: "danger", onClick: (p) => j(e.$index) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 }, 8, ["disabled", "model"])), [[H, g.value]])]), _: 1 });
  };
} };
export {
  we as default
};
