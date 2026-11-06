import { inject as H } from "vue";
import { ref as p } from "vue";
import { computed as x } from "vue";
import { onMounted as Q } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as c } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as _ } from "vue";
import { createCommentVNode as L } from "vue";
import { createElementBlock as P } from "vue";
import { Fragment as X } from "vue";
import { createTextVNode as N } from "vue";
import { withDirectives as R } from "vue";
import { unref as b } from "vue";
import { toDisplayString as z } from "vue";
import { ElNotification as B } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElForm as Z } from "element-plus";
import { ElCard as ee } from "element-plus";
import { vLoading as le } from "element-plus";
import { ho as ae, hp as te, i as V, V as se, ap as D, cP as T, aw as oe, hq as ie } from "../../../../../shared/runtime.js";
import { u as ne } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
import { j as de } from "../../../../../modules/judgeSameValue-9683bdce.js";
const ce = { class: "clearfix" }, re = { style: { float: "right" } }, ue = { key: 1 }, me = { key: 1 }, he = { __name: "coil-plate-convert", setup(fe) {
  const { loaded: pe, rawMatClsKV: k } = ae(), j = H("permission");
  p(), p();
  const w = p({ list: [{ coilIds: [], steelPlateId: void 0 }] }), t = p({ list: [{ coilIds: [], steelPlateId: void 0 }] }), M = { coilIds: [{ required: true, message: "请选择可转换物料", trigger: "change" }], steelPlateId: [{ required: true, message: "请选择转换后物料", trigger: "change" }] }, { tableValidate: O, wrongCellMask: q } = oe({ rules: M }), y = p(false), m = p(false), s = p(false);
  x(() => {
    var a;
    return de(t.value.list, (a = w.value) == null ? void 0 : a.list);
  });
  const J = x(() => y.value || m.value);
  Q(() => {
    E();
  });
  async function E() {
    y.value = true;
    try {
      const a = await te();
      if (V(a)) {
        const o = se(a), i = [];
        o.forEach((e) => {
          var n, f, u;
          e.coilIds = (n = e.classifyColorRollIds) == null ? void 0 : n.map((d) => d.id), e.steelPlateId = (f = e.classifySteelPlateId) == null ? void 0 : f.id, e.coilIdsName = (u = e.classifyColorRollIds) == null ? void 0 : u.map((d) => d.name).join("、"), i.push(e);
        }), t.value.list = i, w.value.list = JSON.parse(JSON.stringify(t.value.list));
      }
    } catch (a) {
      console.log("wms基础配置", a);
    } finally {
      y.value = false;
    }
  }
  function U() {
    s.value = true;
  }
  function $() {
    t.value.list.push({ coilIds: [], steelPlateId: void 0 }), s.value = true;
  }
  function F() {
    t.value.list = JSON.parse(JSON.stringify(w.value.list)), s.value = false;
  }
  function A(a) {
    t.value.list.splice(a, 1);
  }
  async function K() {
    const { validResult: a, dealList: o } = O(t.value.list);
    if (!a) return;
    const i = [];
    t.value.list.forEach((e) => {
      var n;
      if (V(e.coilIds) && V(e.steelPlateId)) {
        const f = [];
        (n = e.coilIds) == null || n.reduce((S, h) => {
          const l = k.value[h];
          f.push({ id: h, name: l.name });
        }, 0);
        const u = k.value[e.steelPlateId], d = {};
        d.id = e.steelPlateId, d.name = u == null ? void 0 : u.name, i.push({ classifyColorRollIds: f, classifySteelPlateId: d });
      }
    });
    try {
      m.value = true, await ie(i), B({ title: "条板转换物料配置设置成功", type: "success", duration: 2500 }), E(), ne("wmsConfig"), s.value = false;
    } catch {
      B({ title: "条板转换物料配置设置失败", type: "error", duration: 2500 });
    } finally {
      m.value = false;
    }
  }
  return (a, o) => {
    const i = I("common-button"), e = I("common-tip-button"), n = Y, f = I("common-table"), u = Z, d = ee, S = W("permission"), h = le;
    return c(), g(d, { shadow: "always" }, { header: r(() => [C("div", ce, [o[2] || (o[2] = C("span", { class: "card-title" }, "条板转换物料配置", -1)), C("span", re, [_(i, { loading: m.value, size: "default", type: "primary", icon: "el-icon-plus", style: { "margin-right": "5px" }, onClick: $ }, null, 8, ["loading"]), s.value ? L("", true) : (c(), g(e, { key: 0, loading: m.value, disabled: s.value, size: "default", type: "warning", icon: "el-icon-edit", onClick: U }, null, 8, ["loading", "disabled"])), s.value ? (c(), P(X, { key: 1 }, [_(i, { loading: m.value, size: "default", type: "warning", style: { "margin-right": "5px", "margin-left": "0" }, onClick: F }, { default: r(() => o[0] || (o[0] = [N("取消")])), _: 1, __: [0] }, 8, ["loading"]), R((c(), g(e, { loading: m.value, "show-tip": "", size: "default", type: "primary", onClick: K }, { default: r(() => o[1] || (o[1] = [N(" 保存 ")])), _: 1, __: [1] }, 8, ["loading"])), [[S, b(j).coilPlateConvertEdit]])], 64)) : L("", true)])])]), default: r(() => [R((c(), g(u, { disabled: J.value, model: t.value, "label-position": "left", "label-width": "130px" }, { default: r(() => [_(f, { data: t.value.list, "empty-text": "暂无数据", "max-height": 500, "cell-class-name": b(q), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: r(() => [_(n, { key: "coilIds", prop: "coilIds", "show-overflow-tooltip": true, "min-width": "130", label: "可转换物料" }, { default: r((l) => [s.value ? (c(), g(D, { modelValue: l.row.coilIds, "onUpdate:modelValue": (v) => l.row.coilIds = v, "basic-class": b(T).STEEL_COIL.V, key: "coilRef_" + l.$index, multiple: "", class: "filter-item", clearable: "", placeholder: "可选择/输入科目、编号搜索", "collapse-tags-tooltip": "", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class"])) : (c(), P("span", ue, z(l.row.coilIdsName), 1))]), _: 1 }), _(n, { key: "steelPlateId", prop: "steelPlateId", "show-overflow-tooltip": true, label: "转换后物料", align: "center" }, { default: r((l) => {
      var v;
      return [s.value ? (c(), g(D, { modelValue: l.row.steelPlateId, "onUpdate:modelValue": (G) => l.row.steelPlateId = G, "basic-class": b(T).STEEL_PLATE.V, key: "steelPlateRef_" + l.$index, class: "filter-item", clearable: "", placeholder: "可选择/输入科目、编号搜索", "collapse-tags-tooltip": "", size: "default", style: { width: "100%", height: "30px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class"])) : (c(), P("span", me, z(((v = l.row.classifySteelPlateId) == null ? void 0 : v.name) || "-"), 1))];
    }), _: 1 }), _(n, { label: "操作", align: "center", width: "65" }, { default: r((l) => [_(i, { size: "default", disabled: !s.value, icon: "el-icon-delete", type: "danger", onClick: (v) => A(l.$index) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 }, 8, ["disabled", "model"])), [[h, y.value]])]), _: 1 });
  };
} };
export {
  he as default
};
