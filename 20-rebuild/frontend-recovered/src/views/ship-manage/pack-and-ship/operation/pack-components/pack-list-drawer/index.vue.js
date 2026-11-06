import { ref as T } from "vue";
import { inject as H } from "vue";
import { reactive as ee } from "vue";
import { computed as X } from "vue";
import { watch as W } from "vue";
import { nextTick as ke } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as Ve } from "vue";
import { openBlock as v } from "vue";
import { createBlock as A } from "vue";
import { withCtx as u } from "vue";
import { withDirectives as xe } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as k } from "vue";
import { unref as l } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as Q } from "vue";
import { createCommentVNode as R } from "vue";
import { createElementBlock as Y } from "vue";
import { Fragment as $ } from "vue";
import { withModifiers as Ee } from "vue";
import { isRef as Ie } from "vue";
import { ElMessage as M } from "element-plus";
import { ElMessageBox as Te } from "element-plus";
import { ElFormItem as Ue } from "element-plus";
import { ElForm as Re } from "element-plus";
import { ElTableColumn as Ae } from "element-plus";
import { ElInput as Ce } from "element-plus";
import { e as Le, p as Me, d as Ne, f as Oe, h as Be, i as Se } from "../../../../../../modules/manual-pack-aab80853.js";
import { _ as De, u as Pe, o as Xe, bi as p, bw as b, od as V, aV as Qe, fa as G, br as te, bs as j, D as S, c as je, S as Fe } from "../../../../../../shared/runtime.js";
import { o as Ke } from "../../../../../../modules/one-code-number-list-af2f89eb.js";
import ze from "../components/chose-pack-operation-form.vue.js";
import { _ as He } from "../../../../../../modules/PicUpload-8580ccfc.js";
import "../../../../../../modules/index-828ab502.js";
import "../../../../../../modules/manuf-warehouse-select-bae65ecc.js";
const We = { class: "head-container" }, Ye = { __name: "index", props: { visible: { type: Boolean, default: false }, bagId: { type: [Number, String], default: void 0 }, editData: { type: Object, default: () => {
} }, typeVal: { type: Number } }, emits: ["update:visible", "handleSuccess", "del", "clearAll"], setup(x, { emit: ae }) {
  const le = T(), ne = T([]), E = H("packData"), oe = H("permission"), ie = H("projectId"), D = ae, _ = x, { visible: P, handleClose: q } = Pe({ emit: D, props: _, field: "visible" }), { maxHeight: se } = Xe({ mainBox: ".drawer-detail", extraBox: [".el-drawer__header", ".head-container", ".remark-detail"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300, extraHeight: 80 }, P), J = T(), c = T(p.STRUCTURE.V), C = T(false), N = T(), O = T(), F = ee({}), r = ee({}), K = T(false), L = T({ attachmentDTOS: [] }), re = X(() => {
    var e;
    const t = [];
    for (const i in p.ENUM) (e = r["source" + i]) != null && e.length || t.push(p.KV[i]);
    return t;
  }), ue = X(() => {
    var e;
    const t = [];
    for (const i in b.ENUM) (e = r["source" + i]) != null && e.length || t.push(b.KV[i]);
    return t;
  }), ce = X(() => {
    var e;
    let t = 0;
    for (const i in p.ENUM) (e = r[i]) != null && e.length && (t += r[i].length);
    return t;
  }), pe = X(() => {
    var e;
    let t = 0;
    for (const i in b.ENUM) (e = r[i]) != null && e.length && (t += r[i].length);
    return t;
  });
  W(N, (t) => {
    var e, i;
    if (_.typeVal !== V.BOX.V) for (const d in p.ENUM) (e = r["source" + d]) != null && e.length && (r[d] = r["source" + d].filter((f) => {
      var w;
      return t === ((w = f.workShop) == null ? void 0 : w.id) || !t;
    }));
    else for (const d in b.ENUM) (i = r["source" + d]) != null && i.length && (r[d] = r["source" + d].filter((f) => {
      var w;
      return t === ((w = f.workShop) == null ? void 0 : w.id) || !t;
    }));
  }), W(E, () => {
    K.value = true;
    const t = [];
    if (_.typeVal !== V.BOX.V) for (const e in p.ENUM) E[e] === null && (E[e] = {}), r[e] = Object.values(E[e]), r["source" + e] = Object.values(E[e]), r[e].length && t.push(p.KV[e]);
    else for (const e in b.ENUM) E[e] === null && (E[e] = {}), r[e] = Object.values(E[e]), r["source" + e] = Object.values(E[e]), r[e].length && t.push(b.KV[e]);
    t.includes(c.value) || (c.value = t[0]), ke(() => {
      K.value = false;
    });
  }, { immediate: true, deep: true }), W(() => _.bagId, (t) => {
    t && (O.value = _.editData.remark);
  }, { immediate: true });
  function de(t) {
    L.value.attachmentDTOS = [];
  }
  function me(t) {
    L.value.attachmentDTOS = (t == null ? void 0 : t.attachmentDTOS) || [];
  }
  async function fe() {
    try {
      if (C.value = true, _.bagId) {
        z({ bagId: _.bagId });
        return;
      } else {
        const t = await J.value.validForm();
        console.log(t), t.valid ? z({ ...t }) : C.value = false;
      }
    } catch {
      C.value = false;
    }
  }
  function he() {
    q(), O.value = "", _.typeVal === V.BOX.V ? c.value = b.BOX.V : c.value = p.STRUCTURE.V, N.value = void 0;
  }
  async function z({ bagId: t, isNew: e, selectBagId: i, serialNumber: d, warehouseId: f }) {
    var w, o;
    try {
      C.value = true;
      const m = { remark: O.value, warehouseId: f, packageLinks: [], projectId: ie.value, attachmentIds: ((o = (w = L.value) == null ? void 0 : w.attachmentDTOS) == null ? void 0 : o.map((h) => h.id)) || [] };
      if (_.typeVal !== V.BOX.V) for (const h in p.ENUM) {
        const g = r[h];
        for (let I = 0; I < (g == null ? void 0 : g.length); I++) {
          const y = g[I];
          console.log(y, "v"), m.packageLinks.push({ id: y.id, numberList: y.numberList, quantity: y.productQuantity, productType: y.productType });
        }
      }
      else for (const h in b.ENUM) {
        const g = r[h];
        for (let I = 0; I < (g == null ? void 0 : g.length); I++) {
          const y = g[I];
          console.log(y, "v"), m.packageLinks.push({ id: y.id, numberList: y.numberList, quantity: y.productQuantity, productType: y.productType });
        }
      }
      _.typeVal !== V.BOX.V ? t ? (m.id = t, await Le(m) && M({ type: "success", message: "更新打包清单成功" })) : e ? (console.log(":params", { ...m, serialNumber: d }), await Me({ ...m, serialNumber: d }) && M({ type: "success", message: "打包成功" })) : (m.id = i, await Ne(m) && M({ type: "success", message: "追加打包成功" })) : t ? (m.id = t, await Oe(m) && M({ type: "success", message: "更新打包清单成功" })) : e ? await Be(m) && M({ type: "success", message: "打包成功" }) : (m.id = i, await Se(m) && M({ type: "success", message: "追加打包成功" })), he(), D("handleSuccess");
    } catch (m) {
      console.log("手动打包", m);
    } finally {
      C.value = false;
    }
  }
  function ge(t) {
    t.productQuantity = t.numberList.length;
  }
  function ye(t) {
    D("del", t, c.value);
  }
  function be() {
    Te.confirm("您选择清空本次打包记录，是否确认？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      D("clearAll");
    }).catch(() => {
      console.log("删除失败");
    });
  }
  const we = ({ columns: t, data: e }) => t.map((d, f) => {
    if (f === 0) return "合计";
    if (["inQuantity", "productQuantity"].find((o) => o === d.property)) {
      const o = e.map((h) => Number(h[d.property])), m = o.every((h) => !Number.isNaN(h)) ? o.reduce((h, g) => h + (Number(g) || 0), 0) : 0;
      return m ? m.toFixed(3) : "";
    }
    return "";
  });
  function _e(t, e) {
    var i;
    if (e.boolOneCode) {
      const d = ((i = e.originNumberList) == null ? void 0 : i.map((f) => f.number)) || [];
      e.numberList = d.slice(0, t);
    }
    e.precision = F[e.id] || 0;
  }
  function ve(t, e) {
    if (isNaN(t) || t === "" || c.value !== p.AUXILIARY_MATERIAL.V) return;
    const d = Math.min(Number(t), e.unPackageQuantity).toFixed(10).replace(/\.?0+$/, ""), f = d.includes(".") ? d.split(".")[1].length : 0;
    F[e.id] = Math.min(f, 10);
  }
  return (t, e) => {
    const i = B("common-button"), d = B("component-radio-button"), f = Ue, w = Re, o = Ae, m = B("common-input-number"), h = B("common-table"), g = Ce, I = B("common-drawer"), y = Ve("permission");
    return v(), A(I, { ref_key: "drawerRef", ref: le, modelValue: l(P), "onUpdate:modelValue": e[4] || (e[4] = (a) => Ie(P) ? P.value = a : null), "before-close": l(q), "custom-class": "drawer-detail", direction: "rtl", size: "75%", title: "打包列表" }, { titleRight: u(() => [xe((v(), A(i, { loading: C.value, size: "default", type: "primary", onClick: fe }, { default: u(() => [U(" 打包 (" + k(x.typeVal === l(V).BOX.V ? pe.value : ce.value) + ") ", 1)]), _: 1 }, 8, ["loading"])), [[y, l(oe).pack]]), n(i, { type: "danger", size: "mini", onClick: be }, { default: u(() => e[5] || (e[5] = [U("清空")])), _: 1, __: [5] })]), content: u(() => [Q("div", We, [n(d, { modelValue: c.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => c.value = a), disabledVal: x.typeVal === l(V).BOX.V ? ue.value : re.value, options: x.typeVal === l(V).BOX.V ? l(b).ENUM : l(p).ENUM, class: "filter-item", size: "small", type: "enum" }, { suffix: u(({ item: a }) => {
      var s;
      return [U(" (" + k((s = r["source" + a.K]) == null ? void 0 : s.length) + ")", 1)];
    }), _: 1 }, 8, ["modelValue", "disabledVal", "options"]), c.value !== l(p).AUXILIARY_MATERIAL.V ? (v(), A(Qe, { key: 0, modelValue: N.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => N.value = a), "workshop-type": x.typeVal === l(V).BOX.V ? l(G).BRIDGE.V : c.value === l(p).ENCLOSURE.V ? l(G).ENCLOSURE.V : l(G).BUILDING.V, class: "filter-item", clearable: "", placeholder: "请选择车间", style: { width: "200px" } }, null, 8, ["modelValue", "workshop-type"])) : R("", true)]), x.bagId ? R("", true) : (v(), A(l(ze), { key: 0, ref_key: "chosePackOperationFormRef", ref: J, packLoading: C.value, packType: c.value, workshopId: N.value, bagId: x.bagId, typeVal: _.typeVal, onHandlePack: z, onIsNewChange: de, onSelectBagIdChange: me }, null, 8, ["packLoading", "packType", "workshopId", "bagId", "typeVal"])), n(h, { data: x.typeVal === l(V).BOX.V ? r[l(b).VK[c.value]] : r[l(p).VK[c.value]], "expand-row-keys": ne.value, "max-height": l(se), "show-empty-symbol": false, "summary-method": we, class: "manual-pack-list", "default-expand-all": "", "empty-text": "暂无数据", "return-source-data": "", "row-key": "id", "show-summary": "", style: { width: "100%" } }, { default: u(() => [n(o, { type: "expand" }, { default: u(({ row: a }) => [a.boolOneCode ? (v(), A(w, { key: 0, style: { "padding-top": "20px", "padding-left": "20px" } }, { default: u(() => [n(f, { class: "one-code-number-list", label: "一物一码编号：" }, { default: u(() => [n(l(Ke), { modelValue: a.numberList, "onUpdate:modelValue": (s) => a.numberList = s, color: "#ffff00", list: a.originNumberList, "tag-width": 100, onChange: (s) => ge(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "list", "onChange"])]), _: 2 }, 1024)]), _: 2 }, 1024)) : R("", true)]), _: 1 }), n(o, { align: "center", label: "序号", type: "index", width: "60" }), (x.typeVal === l(V).BOX.V ? c.value & (l(b).BOX.V | l(b).MACHINE_PART.V) : c.value & (l(p).STRUCTURE.V | l(p).MACHINE_PART.V)) ? (v(), Y($, { key: 0 }, [c.value & l(p).STRUCTURE.V ? (v(), A(o, { key: "name", "show-overflow-tooltip": true, label: "名称", prop: "name", width: "120px" }, { default: u((a) => {
      var s, Z;
      return [a.row.workshop ? (v(), A(te, { key: 0, name: (Z = (s = a.row) == null ? void 0 : s.workshop) == null ? void 0 : Z.name }, null, 8, ["name"])) : R("", true), Q("span", null, k(a.row.name), 1)];
    }), _: 1 })) : R("", true), n(o, { align: "center", label: "单体", prop: "monomer.name", width: "100px" }, { default: u(({ row: a }) => {
      var s;
      return [n(te, { show: a.boolAllPartSendDirectly, color: "#f56c6c", name: "檩条直发" }, null, 8, ["show"]), Q("span", null, k((s = a.monomer) == null ? void 0 : s.name), 1)];
    }), _: 1 }), n(o, { align: "center", label: "区域", prop: "area.name", width: "100px" }), n(o, { align: "center", label: "编号", prop: "serialNumber", width: "120px" }), n(o, { key: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140px", prop: "specification" }), n(o, { key: "length", label: `长度
(mm)`, "show-overflow-tooltip": true, align: "left", "min-width": "85px", prop: "length" }, { default: u((a) => {
      var s;
      return [U(k(l(j)((s = a.row) == null ? void 0 : s.length, l(S).MES_ARTIFACT_L__MM)), 1)];
    }), _: 1 }), n(o, { key: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "80px", prop: "material" }), n(o, { key: "netWeight", label: `单净重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "80px", prop: "netWeight" }, { default: u((a) => [U(k(l(j)(a.row.netWeight, l(S).COM_WT__KG)), 1)]), _: 1 }), n(o, { key: "grossWeight", label: `单毛重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "80px", prop: "grossWeight" }, { default: u((a) => [U(k(l(j)(a.row.grossWeight, l(S).COM_WT__KG)), 1)]), _: 1 })], 64)) : R("", true), c.value === l(p).ENCLOSURE.V ? (v(), Y($, { key: 1 }, [n(o, { align: "center", label: "批次", prop: "area.name", width: "120px" }), n(o, { key: "name", "show-overflow-tooltip": true, align: "center", label: "名称", prop: "name", width: "120px" }, { default: u((a) => [Q("span", null, k(a.row.name), 1)]), _: 1 }), n(o, { align: "center", label: "编号", prop: "serialNumber", width: "120px" }), n(o, { key: "plate", "show-overflow-tooltip": true, align: "center", label: "板型", "min-width": "100px", prop: "plate" }), n(o, { key: "weight", label: `单重
(kg)`, "show-overflow-tooltip": true, align: "center", "min-width": "85px", prop: "weight" }, { default: u((a) => [U(k(a.row.weight), 1)]), _: 1 }), n(o, { key: "surfaceArea", label: `单面积
(m²)`, "show-overflow-tooltip": true, align: "center", "min-width": "85px", prop: "surfaceArea" }, { default: u((a) => [U(k(l(je)(a.row.surfaceArea, "mm²", "m²", l(S).COM_AREA__M2)), 1)]), _: 1 }), n(o, { key: "length", label: `单长
(mm)`, "show-overflow-tooltip": true, align: "center", "min-width": "85px", prop: "length" }, { default: u((a) => {
      var s;
      return [U(k(l(j)((s = a.row) == null ? void 0 : s.length, l(S).MES_ENCLOSURE_L__MM)), 1)];
    }), _: 1 })], 64)) : R("", true), c.value === l(p).AUXILIARY_MATERIAL.V || c.value === l(b).AUXILIARY_MATERIAL.V ? (v(), Y($, { key: 2 }, [n(o, { key: "name", "show-overflow-tooltip": true, label: "名称", prop: "name" }), n(o, { key: "measureUnit", label: "单位", "min-width": "80px", prop: "measureUnit" }), n(o, { key: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", prop: "specification" })], 64)) : R("", true), n(o, { key: "inQuantity", align: "center", label: "入库量", "min-width": "80px", prop: "inQuantity" }), n(o, { key: "unPackageQuantity", align: "center", label: "可打包量", "min-width": "80px", prop: "unPackageQuantity" }), n(o, { align: "center", fixed: "right", label: "打包数量", prop: "productQuantity", "min-width": "120px" }, { default: u(({ row: a }) => [K.value ? R("", true) : (v(), A(m, { key: 0, modelValue: a.productQuantity, "onUpdate:modelValue": (s) => a.productQuantity = s, max: a.unPackageQuantity || a.inQuantity - a.packageQuantity, min: c.value === l(p).AUXILIARY_MATERIAL.V ? 1e-10 : 1, step: 1, precision: c.value === l(p).AUXILIARY_MATERIAL.V ? F[a.id] ?? a.precision ?? 0 : 0, "controls-position": "right", size: "default", style: { width: "100%" }, onChange: (s) => _e(s, a), onInput: (s) => ve(s, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision", "onChange", "onInput"]))]), _: 1 }), n(o, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: u((a) => [n(i, { icon: "el-icon-delete", size: "default", type: "danger", onClick: Ee((s) => ye(a.row.id), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "expand-row-keys", "max-height"]), n(w, { ref: "formRef", model: L.value, size: "default", "label-position": "top", "label-width": "100px" }, { default: u(() => [n(f, { label: "上传附件：", prop: "attachmentDTOS", class: "attachment" }, { default: u(() => [n(l(He), { files: L.value.attachmentDTOS, "onUpdate:files": e[2] || (e[2] = (a) => L.value.attachmentDTOS = a), "file-classify": l(Fe).NORMAL.V, limit: 3, showDownloadBtn: "" }, null, 8, ["files", "file-classify"])]), _: 1 })]), _: 1 }, 8, ["model"]), n(g, { modelValue: O.value, "onUpdate:modelValue": e[3] || (e[3] = (a) => O.value = a), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, class: "remark-detail", maxlength: "255", placeholder: "请填写备注", style: { width: "100%", "margin-top": "10px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, lt = De(Ye, [["__scopeId", "data-v-7a5da60b"]]);
export {
  lt as default
};
