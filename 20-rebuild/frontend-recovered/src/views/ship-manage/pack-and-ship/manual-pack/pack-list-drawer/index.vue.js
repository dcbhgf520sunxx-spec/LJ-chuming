import { ref as _ } from "vue";
import { inject as P } from "vue";
import { reactive as ge } from "vue";
import { computed as B } from "vue";
import { watch as K } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as he } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as n } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as ye } from "vue";
import { createBlock as M } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as V } from "vue";
import { unref as l } from "vue";
import { createElementVNode as S } from "vue";
import { createCommentVNode as U } from "vue";
import { Fragment as X } from "vue";
import { withModifiers as be } from "vue";
import { isRef as we } from "vue";
import { ElMessage as C } from "element-plus";
import { ElFormItem as Ve } from "element-plus";
import { ElForm as ke } from "element-plus";
import { ElTableColumn as ve } from "element-plus";
import { ElInputNumber as _e } from "element-plus";
import { ElInput as xe } from "element-plus";
import { e as Ee, p as Ue, d as Ce, f as Re, h as Me, i as Le } from "../../../../../modules/manual-pack-aab80853.js";
import { u as Te, o as Ne, bi as d, bw as f, od as h, aV as Oe, fa as j, br as $, bs as D, D as L, c as Be, ba as Ae } from "../../../../../shared/runtime.js";
import { o as Ie } from "../../../../../modules/one-code-number-list-af2f89eb.js";
import Se from "../chose-add-method-dialog/index.vue.js";
import "../../../../../modules/index-828ab502.js";
const Xe = { class: "head-container" }, We = { __name: "index", props: { visible: { type: Boolean, default: false }, bagId: { type: [Number, String], default: void 0 }, editData: { type: Object, default: () => {
} }, typeVal: { type: Number } }, emits: ["update:visible", "handleSuccess"], setup(E, { emit: q }) {
  const Y = _(), H = _(), J = _([]), y = P("packData"), Z = P("permission"), ee = P("projectId"), W = q, g = E, { visible: T, handleClose: z } = Te({ emit: W, props: g, field: "visible" }), { maxHeight: te } = Ne({ mainBox: ".drawer-detail", extraBox: [".el-drawer__header", ".head-container", ".remark-detail"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300, extraHeight: 80 }, T), s = _(d.STRUCTURE.V), N = _(false), Q = _(false), O = _(), R = _(), i = ge({}), ae = B(() => {
    var e;
    const a = [];
    for (const r in d.ENUM) (e = i["source" + r]) != null && e.length || a.push(d.KV[r]);
    return a;
  }), le = B(() => {
    var e;
    const a = [];
    for (const r in f.ENUM) (e = i["source" + r]) != null && e.length || a.push(f.KV[r]);
    return a;
  }), oe = B(() => {
    var e;
    let a = 0;
    for (const r in d.ENUM) (e = i[r]) != null && e.length && (a += i[r].length);
    return a;
  }), ne = B(() => {
    var e;
    let a = 0;
    for (const r in f.ENUM) (e = i[r]) != null && e.length && (a += i[r].length);
    return a;
  });
  K(O, (a) => {
    var e, r;
    if (g.typeVal !== h.BOX.V) for (const m in d.ENUM) (e = i["source" + m]) != null && e.length && (i[m] = i["source" + m].filter((p) => {
      var b;
      return a === ((b = p.workshop) == null ? void 0 : b.id) || !a;
    }));
    else for (const m in f.ENUM) (r = i["source" + m]) != null && r.length && (i[m] = i["source" + m].filter((p) => {
      var b;
      return a === ((b = p.workshop) == null ? void 0 : b.id) || !a;
    }));
  }), K(y, () => {
    let a;
    if (g.typeVal !== h.BOX.V) for (const e in d.ENUM) y[e] === null && (y[e] = {}), i[e] = Object.values(y[e]), i["source" + e] = Object.values(y[e]), i[e].length && !a && (a = d.KV[e]);
    else for (const e in f.ENUM) y[e] === null && (y[e] = {}), i[e] = Object.values(y[e]), i["source" + e] = Object.values(y[e]), i[e].length && !a && (a = f.KV[e]);
    s.value = a || s.value;
  }, { immediate: true, deep: true }), K(() => g.bagId, (a) => {
    a && (R.value = g.editData.remark);
  }, { immediate: true });
  function ie() {
    if (g.bagId) {
      F({ bagId: g.bagId });
      return;
    }
    Q.value = true;
  }
  function se() {
    z(), R.value = "", g.typeVal === h.BOX.V ? s.value = f.BOX.V : s.value = d.STRUCTURE.V, O.value = void 0;
  }
  async function F({ bagId: a, isNew: e, selectBagId: r, serialNumber: m }) {
    try {
      N.value = true;
      const p = { remark: R.value, packageLinks: [], productType: s.value, projectId: ee.value };
      if (g.typeVal !== h.BOX.V) for (const b in d.ENUM) {
        const o = i[b];
        for (let k = 0; k < (o == null ? void 0 : o.length); k++) {
          const w = o[k];
          console.log(w, "v"), p.packageLinks.push({ id: w.id, numberList: w.numberList, quantity: w.productQuantity, productType: s.value });
        }
      }
      else for (const b in f.ENUM) {
        const o = i[b];
        for (let k = 0; k < (o == null ? void 0 : o.length); k++) {
          const w = o[k];
          console.log(w, "v"), p.packageLinks.push({ id: w.id, numberList: w.numberList, quantity: w.productQuantity, productType: s.value });
        }
      }
      g.typeVal !== h.BOX.V ? a ? (p.id = a, await Ee(p) && C({ type: "success", message: "更新打包清单成功" })) : e ? (console.log(":params", { ...p, serialNumber: m }), await Ue({ ...p, serialNumber: m }) && C({ type: "success", message: "打包成功" })) : (p.id = r, await Ce(p) && C({ type: "success", message: "追加打包成功" })) : a ? (p.id = a, await Re(p) && C({ type: "success", message: "更新打包清单成功" })) : e ? await Me(p) && C({ type: "success", message: "打包成功" }) : (p.id = r, await Le(p) && C({ type: "success", message: "追加打包成功" })), H.value.handleSuccess(), se(), W("handleSuccess");
    } catch (p) {
      console.log("手动打包", p);
    } finally {
      N.value = false;
    }
  }
  function re(a) {
    a.productQuantity = a.numberList.length;
  }
  function ue(a) {
    g.typeVal === h.BOX.V ? delete y[f.VK[s.value]][a] : delete y[d.VK[s.value]][a];
  }
  function pe(a) {
    return Ae(a, { props: ["inQuantity", "productQuantity"] });
  }
  function ce(a, e) {
    const r = e.originNumberList.map((m) => m.number);
    e.numberList = r.slice(0, a);
  }
  return (a, e) => {
    const r = A("common-button"), m = A("component-radio-button"), p = Ve, b = ke, o = ve, k = _e, w = A("common-table"), de = xe, me = A("common-drawer"), fe = he("permission");
    return v(), I(X, null, [n(me, { ref_key: "drawerRef", ref: Y, title: "打包列表", modelValue: l(T), "onUpdate:modelValue": e[3] || (e[3] = (t) => we(T) ? T.value = t : null), direction: "rtl", "before-close": l(z), size: "75%", "custom-class": "drawer-detail" }, { titleRight: c(() => [ye((v(), M(r, { type: "primary", loading: N.value, size: "default", onClick: ie }, { default: c(() => [x(" 打包 (" + V(E.typeVal === l(h).BOX.V ? ne.value : oe.value) + ") ", 1)]), _: 1 }, 8, ["loading"])), [[fe, l(Z).pack]])]), content: c(() => [S("div", Xe, [n(m, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => s.value = t), size: "default", class: "filter-item", options: E.typeVal === l(h).BOX.V ? l(f).ENUM : l(d).ENUM, type: "enum", disabledVal: E.typeVal === l(h).BOX.V ? le.value : ae.value }, { suffix: c(({ item: t }) => {
      var u;
      return [x(" (" + V((u = i["source" + t.K]) == null ? void 0 : u.length) + ")", 1)];
    }), _: 1 }, 8, ["modelValue", "options", "disabledVal"]), s.value !== l(d).AUXILIARY_MATERIAL.V ? (v(), M(Oe, { key: 0, modelValue: O.value, "onUpdate:modelValue": e[1] || (e[1] = (t) => O.value = t), "workshop-type": E.typeVal === l(h).BOX.V ? l(j).BRIDGE.V : s.value === l(d).ENCLOSURE.V ? l(j).ENCLOSURE.V : l(j).BUILDING.V, placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue", "workshop-type"])) : U("", true)]), n(w, { data: E.typeVal === l(h).BOX.V ? i[l(f).VK[s.value]] : i[l(d).VK[s.value]], "return-source-data": "", "show-empty-symbol": false, "show-summary": "", "summary-method": pe, "empty-text": "暂无数据", "max-height": l(te), style: { width: "100%" }, class: "manual-pack-list", "expand-row-keys": J.value, "default-expand-all": "", "row-key": "rowKey" }, { default: c(() => [n(o, { type: "expand" }, { default: c(({ row: t }) => [t.boolOneCode ? (v(), M(b, { key: 0, style: { "padding-top": "20px", "padding-left": "20px" } }, { default: c(() => [n(p, { label: "一物一码编号：", class: "pack-list-drawer-one-code-number-list" }, { default: c(() => [n(l(Ie), { modelValue: t.numberList, "onUpdate:modelValue": (u) => t.numberList = u, list: t.originNumberList, color: "#ffff00", "tag-width": 100, onChange: (u) => re(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "list", "onChange"])]), _: 2 }, 1024)]), _: 2 }, 1024)) : U("", true)]), _: 1 }), n(o, { label: "序号", type: "index", align: "center", width: "60" }), (E.typeVal === l(h).BOX.V ? s.value & (l(f).BOX.V | l(f).MACHINE_PART.V) : s.value & (l(d).STRUCTURE.V | l(d).MACHINE_PART.V)) ? (v(), I(X, { key: 0 }, [s.value & l(d).STRUCTURE.V ? (v(), M(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: c((t) => {
      var u, G;
      return [t.row.workshop ? (v(), M($, { key: 0, name: (G = (u = t.row) == null ? void 0 : u.workshop) == null ? void 0 : G.name }, null, 8, ["name"])) : U("", true), S("span", null, V(t.row.name), 1)];
    }), _: 1 })) : U("", true), n(o, { prop: "monomer.name", label: "单体", align: "center", width: "100px" }, { default: c(({ row: t }) => {
      var u;
      return [n($, { show: t.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), S("span", null, V((u = t.monomer) == null ? void 0 : u.name), 1)];
    }), _: 1 }), n(o, { prop: "area.name", label: "区域", align: "center", width: "100px" }), n(o, { prop: "serialNumber", label: "编号", align: "center", width: "120px" }), n(o, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140px" }), n(o, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: c((t) => {
      var u;
      return [x(V(l(D)((u = t.row) == null ? void 0 : u.length, l(L).MES_ARTIFACT_L__MM)), 1)];
    }), _: 1 }), n(o, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }), n(o, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: c((t) => [x(V(l(D)(t.row.netWeight, l(L).COM_WT__KG)), 1)]), _: 1 }), n(o, { key: "grossWeight", prop: "grossWeight", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: c((t) => [x(V(l(D)(t.row.grossWeight, l(L).COM_WT__KG)), 1)]), _: 1 })], 64)) : U("", true), s.value === l(d).ENCLOSURE.V ? (v(), I(X, { key: 1 }, [n(o, { prop: "area.name", label: "批次", align: "center", width: "120px" }), n(o, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: c((t) => [S("span", null, V(t.row.name), 1)]), _: 1 }), n(o, { prop: "serialNumber", label: "编号", align: "center", width: "120px" }), n(o, { key: "plate", align: "center", prop: "plate", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" }), n(o, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: `单重
(kg)`, align: "center", "min-width": "85px" }, { default: c((t) => [x(V(t.row.weight), 1)]), _: 1 }), n(o, { key: "surfaceArea", prop: "surfaceArea", "show-overflow-tooltip": true, label: `单面积
(m²)`, align: "center", "min-width": "85px" }, { default: c((t) => [x(V(l(Be)(t.row.surfaceArea, "mm²", "m²", l(L).COM_AREA__M2)), 1)]), _: 1 }), n(o, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `单长
(mm)`, align: "center", "min-width": "85px" }, { default: c((t) => {
      var u;
      return [x(V(l(D)((u = t.row) == null ? void 0 : u.length, l(L).MES_ENCLOSURE_L__MM)), 1)];
    }), _: 1 })], 64)) : U("", true), s.value === l(d).AUXILIARY_MATERIAL.V || s.value === l(f).AUXILIARY_MATERIAL.V ? (v(), I(X, { key: 2 }, [n(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }), n(o, { key: "measureUnit", prop: "measureUnit", label: "单位", "min-width": "80px" }), n(o, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120" })], 64)) : U("", true), n(o, { key: "inQuantity", prop: "inQuantity", label: "入库量", align: "center", "min-width": "80px" }), n(o, { key: "unPackageQuantity", prop: "unPackageQuantity", label: "可打包量", align: "center", "min-width": "80px" }), n(o, { prop: "productQuantity", label: "打包数量", align: "center", width: "120px", fixed: "right" }, { default: c(({ row: t }) => [n(k, { modelValue: t.productQuantity, "onUpdate:modelValue": (u) => t.productQuantity = u, step: 1, min: 1, max: t.unPackageQuantity || t.inQuantity - t.packageQuantity, size: "default", style: { width: "100%" }, "controls-position": "right", onChange: (u) => ce(u, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), n(o, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: c((t) => [n(r, { type: "danger", icon: "el-icon-delete", size: "default", onClick: be((u) => ue(t.row.id), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"]), n(de, { class: "remark-detail", modelValue: R.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => R.value = t), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 3 }, maxlength: "255", placeholder: "请填写备注", style: { width: "100%", "margin-top": "10px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]), n(l(Se), { ref_key: "choseDialogRef", ref: H, visible: Q.value, "onUpdate:visible": e[4] || (e[4] = (t) => Q.value = t), packType: s.value, packLoading: N.value, typeVal: g.typeVal, onHandlePack: F }, null, 8, ["visible", "packType", "packLoading", "typeVal"])], 64);
  };
} };
export {
  We as default
};
