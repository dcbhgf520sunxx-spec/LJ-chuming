import { _ as x, O as L } from "../shared/runtime.js";
import { ref as r } from "vue";
import { onMounted as b } from "vue";
import { onUnmounted as C } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as p } from "vue";
import { Fragment as D } from "vue";
import { renderList as M } from "vue";
import { normalizeClass as A } from "vue";
import { toDisplayString as E } from "vue";
import { normalizeStyle as R } from "vue";
const B = { class: "toc-items" }, N = ["title", "onClick"], q = { __name: "anchor-nav", props: { scrollContainerClass: { type: String, default: ".anchor-container" }, titleClass: { type: String, default: ".anchor-title" } }, setup(m, { expose: k }) {
  const h = m, T = r(), g = r(), s = r(), t = r([]), n = r(0), i = r(false), _ = () => {
    n.value = 0, t.value = [], i.value && s.value.removeEventListener("scroll", u), s.value = document.querySelector(h.scrollContainerClass), Array.from(s.value.querySelectorAll(h.titleClass)).forEach((a, o) => {
      var c;
      let e = "";
      (c = a.dataset) != null && c.anchorLabel ? e = a.dataset.anchorLabel : e = a.innerText.replace(/[#\s]/g, ""), console.log(e), t.value.push({ index: o, label: e || "--", titleDOM: a });
    }), s.value.addEventListener("scroll", u), i.value = true;
  }, S = (l) => {
    n.value = l.index;
    const a = l.titleDOM.offsetTop - t.value[0].titleDOM.offsetTop;
    s.value.scrollTo({ top: a, behavior: "smooth" });
  }, y = () => {
    var o;
    const l = s.value.scrollTop, a = (o = t.value) != null && o.length ? t.value[0].titleDOM.offsetTop : 0;
    for (let e = 0; e < t.value.length; e++) {
      const c = t.value[e].titleDOM.offsetTop - a;
      let d = 0;
      if (e < t.value.length - 1 && (d = t.value[e + 1].titleDOM.offsetTop - a), l === c || e < t.value.length - 1 && l > c && l < d) {
        n.value = e;
        break;
      } else if (e === t.value.length - 1) {
        const O = t.value[e - 1].titleDOM.offsetTop - a;
        if (l > O) {
          n.value = e;
          break;
        }
      }
    }
  }, u = L((l) => {
    l.stopPropagation(), y();
  }, 200);
  return b(() => {
    _();
  }), C(() => {
    s.value.removeEventListener("scroll", u), i.value = false;
  }), k({ refreshAnchorList: _ }), (l, a) => (f(), v("div", { ref_key: "containerRef", ref: g, class: "toc-wrapper" }, [p("ul", B, [(f(true), v(D, null, M(t.value, (o) => (f(), v("li", { key: o.index, class: "toc-item" }, [p("a", { class: A(["toc-link", { active: o.index === n.value }]), title: o.label, onClick: (e) => S(o) }, E(o.label), 11, N)]))), 128))]), p("div", { ref_key: "markerRef", ref: T, class: "toc-marker", style: R({ top: n.value * 24 + "px" }) }, null, 4)], 512));
} }, I = x(q, [["__scopeId", "data-v-97cd6437"]]);
export {
  I as a
};
