import { ref as D } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as b } from "vue";
import { createBlock as S } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as o } from "vue";
import { unref as m } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as B } from "vue";
import { renderList as q } from "vue";
import { createTextVNode as W } from "vue";
import { isRef as $ } from "vue";
import { createCommentVNode as X } from "vue";
import { ElDescriptionsItem as Y } from "element-plus";
import { ElImage as Z } from "element-plus";
import { ElDescriptions as ee } from "element-plus";
import { _ as te, u as ae, mI as z, iy as le, a3 as F } from "../../../../../shared/runtime.js";
import { a as ie } from "../../../../../modules/inspect-realtime-8a5aa6e5.js";
import { u as ne } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { b as re } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const se = { class: "imgs-box" }, oe = ["src"], ce = { class: "imgs-box" }, me = ["src"], de = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(d, { emit: L }) {
  const { showDrawing: k, drawingRow: y, drawingPreview: P } = ne({ pidField: "productId", typeField: "taskTypeEnum" }), H = D(), M = L, N = d, u = D(), T = D(false), O = D(), { visible: I, handleClose: G } = ae({ emit: M, props: N, field: "visible", showHook: Q });
  const drawingLoading = D(false);
  async function J() {
    drawingLoading.value = true;
    u.value = void 0;
    var i, _, w, h;
    let r = [];
    const c = { qhseId: N.detailData.id };
    try {
      const a = await ie(c);
      a.imgUrls = a.attachmentDTOS && a.attachmentDTOS.map((f) => f.imageUrl), a != null && a.qhseRectifyDTOS && (a != null && a.qhseRectifyDTOS.length) && (a.rectifyName = (i = a.qhseRectifyDTOS[0]) == null ? void 0 : i.name, a.rectifyTime = (_ = a.qhseRectifyDTOS[0]) == null ? void 0 : _.createTime, a.rectifyAttachmentDTOS = (w = a.qhseRectifyDTOS[0]) == null ? void 0 : w.attachmentDTOS, a.rectifyImgUrls = a.rectifyAttachmentDTOS && a.rectifyAttachmentDTOS.map((f) => f == null ? void 0 : f.imageUrl), a.rectifyRemark = (h = a.qhseRectifyDTOS[0]) == null ? void 0 : h.remark), a.number && !Array.isArray(a.number) && (a.number = [a.number]), r = a;
    } catch (a) {
      console.log(a);
    } finally {
      if (c.qhseId === N.detailData.id) {
        u.value = r;
        drawingLoading.value = false;
      }
    }
  }
  function K(r) {
    const annotation = u.value?.id === r.id ? u.value?.drawingLabel || r.drawingLabel : r.drawingLabel;
    if (annotation) {
      O.value = annotation;
      T.value = true;
      return;
    }
    r.taskTypeEnum === F.ARTIFACT.V || r.taskTypeEnum === F.ASSEMBLE.V ? r.number = [0] : r.number = void 0;
    P(r);
  }
  function Q() {
    J();
  }
  return (r, c) => {
    const i = Y, _ = Z, w = j("common-button"), h = ee, a = j("common-drawer");
    return b(), S(a, { ref_key: "drawerRef", ref: H, title: "质检报告", modelValue: m(I), "onUpdate:modelValue": c[3] || (c[3] = (f) => $(I) ? I.value = f : null), direction: "rtl", "before-close": m(G), size: "40%" }, { titleRight: l(() => c[4] || (c[4] = [])), content: l(() => {
      var f, V, E, R, U, x, C, A;
      return [n(h, { data: d.detailData, column: 2, size: "large", border: "" }, { default: l(() => [n(i, { align: "center", label: "项目", span: 2 }, { default: l(() => {
        var e, t, p, g;
        return [s("span", null, o((t = (e = d.detailData) == null ? void 0 : e.project) == null ? void 0 : t.serialNumber) + "-" + o((g = (p = d.detailData) == null ? void 0 : p.project) == null ? void 0 : g.shortName), 1)];
      }), _: 1 }), n(i, { align: "center", label: "编号" }, { default: l(() => {
        var e, t;
        return [s("span", null, o(((e = d.detailData) == null ? void 0 : e.serialNumber) || "-") + " " + o(`（${((t = d.detailData) == null ? void 0 : t.number) || "-"}）`), 1)];
      }), _: 1 }), n(i, { align: "center", label: "规格" }, { default: l(() => {
        var e, t, p;
        return [s("span", null, o(((e = d.detailData) == null ? void 0 : e.status) === m(z).TO_BE_INSPECTED.V ? ((t = d.detailData) == null ? void 0 : t.specification) || "-" : ((p = u.value) == null ? void 0 : p.specification) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "质检人" }, { default: l(() => {
        var e, t;
        return [s("span", null, o(((t = (e = d.detailData) == null ? void 0 : e.inspectUserNames) == null ? void 0 : t.join()) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "班组" }, { default: l(() => {
        var e, t;
        return [s("span", null, o(((t = (e = d.detailData) == null ? void 0 : e.team) == null ? void 0 : t.name) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "工序" }, { default: l(() => {
        var e;
        return [s("span", null, o(((e = d.detailData) == null ? void 0 : e.processName) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "状态" }, { default: l(() => {
        var e;
        return [s("span", null, o(m(z).VL[(e = d.detailData) == null ? void 0 : e.status] || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "质量分类" }, { default: l(() => {
        var e;
        return [s("span", null, o(((e = u.value) == null ? void 0 : e.levelOneName) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "子类" }, { default: l(() => {
        var e;
        return [s("span", null, o(((e = u.value) == null ? void 0 : e.levelTwoName) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "扣分" }, { default: l(() => {
        var e;
        return [s("span", null, o(((e = u.value) == null ? void 0 : e.behaviorScore) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "处罚" }, { default: l(() => {
        var e;
        return [s("span", null, o(((e = u.value) == null ? void 0 : e.penalty) ?? "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "整改前", span: 2 }, { default: l(() => {
        var e;
        return [s("div", se, [(b(true), v(B, null, q((e = u.value) == null ? void 0 : e.attachmentDTOS, (t) => {
          var p, g;
          return b(), v("div", { key: t.id }, [((p = t.name) == null ? void 0 : p.split(".").slice(-1)[0]) !== "mp4" ? (b(), S(_, { "preview-src-list": (g = u.value) == null ? void 0 : g.imgUrls, "initial-index": 1, key: t.id, src: t.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])) : (b(), v("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${t.id}`, autoplay: false, loop: false, muted: true, key: t.imageUrl, src: t.imageUrl }, null, 8, oe))]);
        }), 128))])];
      }), _: 1 }), n(i, { align: "center", label: "文字备注", span: 2 }, { default: l(() => {
        var e;
        return [s("span", null, o(((e = u.value) == null ? void 0 : e.remark) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "整改后", span: 2 }, { default: l(() => {
        var e;
        return [s("div", ce, [(b(true), v(B, null, q((e = u.value) == null ? void 0 : e.rectifyAttachmentDTOS, (t) => {
          var p, g;
          return b(), v("div", { key: t.id }, [((p = t.name) == null ? void 0 : p.split(".").slice(-1)[0]) !== "mp4" ? (b(), S(_, { "preview-src-list": (g = u.value) == null ? void 0 : g.rectifyImgUrls, "initial-index": 1, key: t.id, src: t.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])) : (b(), v("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${t.id}`, autoplay: false, loop: false, muted: true, key: t.imageUrl, src: t.imageUrl }, null, 8, me))]);
        }), 128))])];
      }), _: 1 }), n(i, { align: "center", label: "文字备注", span: 2 }, { default: l(() => {
        var e;
        return [s("span", null, o(((e = u.value) == null ? void 0 : e.rectifyRemark) || "-"), 1)];
      }), _: 1 }), n(i, { align: "center", label: "图纸标注", span: 2 }, { default: l(() => [n(w, { size: "default", type: "primary", disabled: drawingLoading.value, onClick: c[0] || (c[0] = (e) => K(d.detailData)) }, { default: l(() => c[5] || (c[5] = [W("查看图纸")])), _: 1, __: [5] }, 8, ["disabled"])]), _: 1 })]), _: 1 }, 8, ["data"]), n(m(re), { visible: m(k), "onUpdate:visible": c[1] || (c[1] = (e) => $(k) ? k.value = e : null), "bool-bim": (f = m(y)) == null ? void 0 : f.boolBim, drawingSN: (V = m(y)) == null ? void 0 : V.drawingSN, "monomer-id": (E = m(y)) == null ? void 0 : E.monomerId, "area-id": (R = m(y)) == null ? void 0 : R.areaId, "serial-number": (U = m(y)) == null ? void 0 : U.serialNumber, productId: (x = m(y)) == null ? void 0 : x.productId, productType: (C = m(y)) == null ? void 0 : C.productType, projectType: (A = m(y)) == null ? void 0 : A.projectType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "area-id", "serial-number", "productId", "productType", "projectType"]), T.value ? (b(), S(le, { key: 0, isVisible: T.value, showType: "attachment", id: O.value, onClose: c[2] || (c[2] = (e) => T.value = false) }, null, 8, ["isVisible", "id"])) : X("", true)];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Se = te(de, [["__scopeId", "data-v-53ecafd7"]]);
export {
  Se as default
};
