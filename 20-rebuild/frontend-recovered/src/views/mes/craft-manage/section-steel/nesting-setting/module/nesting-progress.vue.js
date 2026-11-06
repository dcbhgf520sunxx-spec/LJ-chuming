import { ref as b } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as s } from "vue";
import { createBlock as u } from "vue";
import { withCtx as o } from "vue";
import { withDirectives as x } from "vue";
import { withModifiers as S } from "vue";
import { unref as p } from "vue";
import { createTextVNode as E } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as a } from "vue";
import { createElementBlock as d } from "vue";
import { Fragment as U } from "vue";
import { renderList as Y } from "vue";
import { normalizeStyle as $ } from "vue";
import { createCommentVNode as R } from "vue";
import { isRef as q } from "vue";
import { ElMessageBox as j } from "element-plus";
import { ElNotification as z } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElTooltip as F } from "element-plus";
import { vLoading as G } from "element-plus";
import { n as J, b as K } from "../../../../../../modules/nesting-setting-83aca0bd.js";
import { _ as Q, u as X, o as Z, no as m, np as ee, nr as V, ca as te } from "../../../../../../shared/runtime.js";
const oe = { key: 0, style: { width: "100%", display: "flex" } }, le = { key: 0 }, ne = { key: 1 }, se = { key: 0 }, ae = { key: 1 }, ie = { __name: "nesting-progress", props: { visible: { type: Boolean, default: false }, batchId: { type: Number, default: void 0 } }, emits: ["update:visible", "success"], setup(B, { emit: C }) {
  const v = C, N = b([]), f = b(false), h = B, { visible: w, handleClose: _ } = X({ emit: v, props: h, field: "visible", showHook: D }), { maxHeight: O } = Z({ mainBox: ".common-dialog", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }), y = b({});
  async function D() {
    try {
      f.value = true;
      const { content: i } = await J({ batchId: h.batchId });
      i[0].typesettingDTOS.forEach((l) => {
        var c;
        l.assembleLength = l.typesettingTypeEnum === m.UN_LOSSY.V ? 0 : l.length, l.linkDOList.map((t) => {
          y.value[t.serialNumber] || (y.value[t.serialNumber] = ee()), t.lengthColor = y.value[t.serialNumber], l.typesettingTypeEnum === m.UN_LOSSY.V && (l.assembleLength += t.length);
        }), l.areaName = (c = l.areaName) == null ? void 0 : c.join(",");
      }), N.value = i[0].typesettingDTOS;
    } catch {
      console.log("获取套料成果失败");
    } finally {
      f.value = false;
    }
  }
  async function H() {
    try {
      j.confirm("是否确认删除套料成果", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
        try {
          const i = [];
          i.push(h.batchId), await K(i), z({ title: "删除成功", type: "success", duration: 2500 }), _(), v("success");
        } catch (i) {
          console.log("删除失败", i);
        }
      });
    } catch (i) {
      console.log(i, "删除失败");
    }
  }
  return (i, l) => {
    const c = k("common-button"), t = W, L = F, I = k("common-table"), M = k("common-dialog"), T = P("permission"), A = G;
    return s(), u(M, { width: "100%", "show-close": false, modal: "", fullscreen: "", title: "套料成果", "append-to-body": "", modelValue: p(w), "onUpdate:modelValue": l[0] || (l[0] = (e) => q(w) ? w.value = e : null), "before-close": p(_) }, { titleRight: o(() => [x((s(), u(c, { onClick: S(p(_), ["stop"]), class: "filter-item", type: "success", size: "default" }, { default: o(() => l[1] || (l[1] = [E("确认")])), _: 1, __: [1] }, 8, ["onClick"])), [[T, p(V).saveNestingResult]]), x((s(), u(c, { onClick: S(H, ["stop"]), class: "filter-item", type: "danger", size: "default" }, { default: o(() => l[2] || (l[2] = [E(" 删除 ")])), _: 1, __: [2] })), [[T, p(V).delNestingResult]])]), default: o(() => [x((s(), u(I, { ref: "tableRef", data: N.value, "max-height": p(O) + 160, style: { width: "100%" }, "row-key": "id" }, { default: o(() => [n(t, { label: "序号", type: "index", align: "center", width: "60" }), n(t, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "套料编号", align: "left", width: "180px" }, { default: o((e) => [r("span", null, a(e.row.serialNumber), 1)]), _: 1 }), n(t, { key: "nestingResult", prop: "nestingResult", label: "套料成果", "header-align": "center", width: "600px" }, { default: o((e) => [e.row.linkDOList.length > 0 ? (s(), d("div", oe, [(s(true), d(U, null, Y(e.row.linkDOList, (g) => (s(), u(L, { key: g, effect: "dark", content: g.serialNumber, placement: "top-start" }, { default: o(() => [r("div", { style: $(`padding: 0 5px; display:inline-block; width:${(g.length / e.row.assembleLength * 100).toFixed(2)}%; color: #fff; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; height: 30px; background-color: ${g.lengthColor};line-height: 30px; margin-left: ${e.row.kerfLength / e.row.assembleLength * 100}% ;margin-right: ${e.row.kerfLength / e.row.assembleLength * 100}%`) }, a(g.serialNumber), 5)]), _: 2 }, 1032, ["content"]))), 128)), e.row.typesettingTypeEnum === p(m).LOSSY.V ? (s(), u(L, { key: 0, effect: "dark", content: "余料", placement: "top-start" }, { default: o(() => l[3] || (l[3] = [r("div", { class: "shadow", style: { flex: "1" } }, null, -1)])), _: 1, __: [3] })) : R("", true)])) : R("", true)]), _: 1 }), n(t, { key: "typesettingAssembleTypeEnum", prop: "typesettingAssembleTypeEnum", "show-overflow-tooltip": true, label: "材料属性", align: "center", width: "120px" }, { default: o((e) => [r("span", null, a(e.row.typesettingAssembleTypeEnum ? p(te).VL[e.row.typesettingAssembleTypeEnum] : "-"), 1)]), _: 1 }), n(t, { key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "区域", align: "center", width: "120px" }, { default: o((e) => [r("span", null, a(e.row.areaName), 1)]), _: 1 }), n(t, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "母材长度（mm）", align: "center", width: "150px" }, { default: o((e) => [e.row.typesettingTypeEnum === p(m).UN_LOSSY.V ? (s(), d("span", le, "-")) : (s(), d("span", ne, a(e.row.length), 1))]), _: 1 }), n(t, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "母材规格", align: "center", width: "150px" }, { default: o((e) => [r("span", null, a(e.row.specification), 1)]), _: 1 }), n(t, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center", width: "110px" }, { default: o((e) => [r("span", null, a(e.row.material), 1)]), _: 1 }), n(t, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "母材总重", align: "center", width: "150px" }, { default: o((e) => [e.row.typesettingTypeEnum === p(m).UN_LOSSY.V ? (s(), d("span", se, "-")) : (s(), d("span", ae, a(e.row.netWeight), 1))]), _: 1 }), n(t, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", width: "120px" }, { default: o((e) => [r("span", null, a(e.row.quantity), 1)]), _: 1 }), n(t, { key: "typesettingLength", prop: "typesettingLength", "show-overflow-tooltip": true, label: "套料长度（mm）", align: "center", width: "150px" }, { default: o((e) => [r("span", null, a(e.row.typesettingLength), 1)]), _: 1 }), n(t, { key: "lossRate", prop: "lossRate", "show-overflow-tooltip": true, label: "套料损耗", align: "center", width: "80px" }, { default: o((e) => [r("span", null, a(e.row.lossRate) + "%", 1)]), _: 1 }), n(t, { key: "kerfLossRate", prop: "kerfLossRate", "show-overflow-tooltip": true, label: "原材料损耗（mm）", align: "center", width: "140px" }, { default: o((e) => [r("span", null, a(e.row.kerfLossRate), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[A, f.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, de = Q(ie, [["__scopeId", "data-v-8fcf6f17"]]);
export {
  de as default
};
