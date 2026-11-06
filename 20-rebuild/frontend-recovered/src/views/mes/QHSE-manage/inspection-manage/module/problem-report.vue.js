import { ref as O } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as c } from "vue";
import { createBlock as h } from "vue";
import { withCtx as s } from "vue";
import { createVNode as i } from "vue";
import { unref as v } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as o } from "vue";
import { withDirectives as C } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as k } from "vue";
import { renderList as w } from "vue";
import { isRef as z } from "vue";
import { ElDescriptionsItem as A } from "element-plus";
import { ElImage as B } from "element-plus";
import { ElDescriptions as E } from "element-plus";
import { vLoading as j } from "element-plus";
import { a as F } from "../../../../../modules/index-cfd8d896.js";
import { _ as H, u as $, bW as K, p as W } from "../../../../../shared/runtime.js";
const G = { class: "imgs-box" }, J = ["src"], M = { class: "imgs-box" }, P = ["src"], Q = { __name: "problem-report", props: { visible: { type: Boolean, default: false }, userId: { type: [Number, String] }, currentDateInfo: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(I, { emit: U }) {
  const q = U, T = I, { visible: D, handleClose: R } = $({ emit: q, props: T, field: "visible", showHook: L }), p = O([]), l = O(), S = O();
  async function N() {
    var m, u;
    try {
      const n = { pageNumber: 1, pageSize: 500, boolApp: false, type: 6, userId: T.userId, specifiedDate: (m = T.currentDateInfo) == null ? void 0 : m.inspectionDate }, { content: _ } = await F(n);
      _.map((a) => {
        var y, b, e, t;
        return a.qualityTypeListStr = a.qualityTypeList && a.qualityTypeList.join("、"), a.imgUrls = a.attachmentDTOS && a.attachmentDTOS.map((d) => d.imageUrl), a.qhseRectifyDTOS && a.qhseRectifyDTOS.length && (a.rectifyName = (y = a.qhseRectifyDTOS[0]) == null ? void 0 : y.name, a.rectifyTime = (b = a.qhseRectifyDTOS[0]) == null ? void 0 : b.createTime, a.rectifyAttachmentDTOS = (e = a.qhseRectifyDTOS[0]) == null ? void 0 : e.attachmentDTOS, a.rectifyImgUrls = a.rectifyAttachmentDTOS && a.rectifyAttachmentDTOS.map((d) => d.imageUrl), a.rectifyRemark = (t = a.qhseRectifyDTOS[0]) == null ? void 0 : t.remark), a;
      }), p.value = _ || [], p.value.length ? (S.value = ((u = p.value[0]) == null ? void 0 : u.id) || void 0, l.value = p.value[0]) : l.value = void 0;
    } catch (n) {
      console.log(n);
    }
  }
  function L() {
    N();
  }
  function V(m) {
    l.value = p.value.find((u) => u.id === m);
  }
  return (m, u) => {
    const n = A, _ = B, a = E, y = x("common-drawer"), b = j;
    return c(), h(y, { ref: "drawerRef", title: "安环问题报告", modelValue: v(D), "onUpdate:modelValue": u[1] || (u[1] = (e) => z(D) ? D.value = e : null), contentLoading: m.tableLoading, "before-close": v(R), size: "50%" }, { content: s(() => [i(v(K), { ref: "tagTabsRef", modelValue: S.value, "onUpdate:modelValue": u[0] || (u[0] = (e) => S.value = e), class: "tabs-style", style: { display: "inline-block" }, data: p.value, itemKey: "id", onChange: V }, { default: s(({ item: e }) => [r("span", null, o(e.qhseNumber), 1)]), _: 1 }, 8, ["modelValue", "data"]), C((c(), h(a, { data: l.value, column: 2, size: "large", border: "" }, { default: s(() => [i(n, { align: "center", label: "巡检人" }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.userName) || "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "日期" }, { default: s(() => {
      var e, t;
      return [r("span", null, o((e = l.value) != null && e.createTime ? v(W)((t = l.value) == null ? void 0 : t.createTime, "{y}-{m}-{d}") : "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "问题编号" }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.qhseNumber) || "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "责任人" }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.dutyName) || "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "质量分类" }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.levelOneName) || "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "子类" }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.levelTwoName) || "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "扣分" }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.behaviorScore) || "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "处罚" }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.penalty) ?? "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "整改前", span: 2 }, { default: s(() => {
      var e;
      return [r("div", G, [(c(true), f(k, null, w((e = l.value) == null ? void 0 : e.attachmentDTOS, (t) => {
        var d, g;
        return c(), f("div", { key: t.id }, [((d = t.name) == null ? void 0 : d.split(".").slice(-1)[0]) !== "mp4" ? (c(), h(_, { "preview-src-list": (g = l.value) == null ? void 0 : g.imgUrls, "initial-index": 1, key: t.id, src: t.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])) : (c(), f("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${t.id}`, autoplay: false, loop: false, muted: true, key: t.imageUrl, src: t.imageUrl }, null, 8, J))]);
      }), 128))])];
    }), _: 1 }), i(n, { align: "center", label: "文字备注", span: 2 }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.remark) || "-"), 1)];
    }), _: 1 }), i(n, { align: "center", label: "整改后", span: 2 }, { default: s(() => {
      var e;
      return [r("div", M, [(c(true), f(k, null, w((e = l.value) == null ? void 0 : e.rectifyAttachmentDTOS, (t) => {
        var d, g;
        return c(), f("div", { key: t.id }, [((d = t.name) == null ? void 0 : d.split(".").slice(-1)[0]) !== "mp4" ? (c(), h(_, { "preview-src-list": (g = l.value) == null ? void 0 : g.rectifyImgUrls, "initial-index": 1, key: t.id, src: t.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])) : (c(), f("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${t.id}`, autoplay: false, loop: false, muted: true, key: t.imageUrl, src: t.imageUrl }, null, 8, P))]);
      }), 128))])];
    }), _: 1 }), i(n, { align: "center", label: "文字备注", span: 2 }, { default: s(() => {
      var e;
      return [r("span", null, o(((e = l.value) == null ? void 0 : e.rectifyRemark) || "-"), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data"])), [[b, m.listLoading]])]), _: 1 }, 8, ["modelValue", "contentLoading", "before-close"]);
  };
} }, ee = H(Q, [["__scopeId", "data-v-40f27454"]]);
export {
  ee as default
};
